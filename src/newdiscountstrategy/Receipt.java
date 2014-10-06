package newdiscountstrategy;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {

    private static int receiptNumber = 0;
    private LineItem[] lineItems = new LineItem[0];
    private Customer customer;
    private Date receiptDate;
    private StoreDatabase db;

    public Receipt(StoreDatabase db) {
        this.db = db;
        receiptDate = new Date();
        receiptNumber++;

    }

    public static int getReceiptNumber() {
        return receiptNumber;
    }

    public static void setReceiptNumber(int receiptNumber) {
        Receipt.receiptNumber = receiptNumber;
    }

    public Date getDate() {

        return receiptDate;
    }

   
    public void setDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

   
    public final void addCustomer(String custID) {;
        customer = db.findCustomer(custID);
    }

    
    public final void addItem(String prodID, int qty) {

        LineItem item = new LineItem(prodID, qty, db);
        addToArray(item);
    }

    private void addToArray(LineItem item) {

        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }

    
    public final double getTotalBeforeDiscount() {

        double total = 0;

        for (LineItem lineItem : lineItems) {
            total += (lineItem.getUnitCost() * lineItem.getQty());
        }

        return total;
    }

    
    public final double getTotalAfterDiscount() {

        double total = 0;

        for (LineItem lineItem : lineItems) {
            total += lineItem.getSubTotal();
        }

        return total;

    }

    /**
     * Generates the receipt Inserts the date and time
     */
    
    public final void generateReceipt() {

        System.out.println("Receipt # " + receiptNumber);
        String format = "MM/dd/yyyy hh:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String formattedDate = sdf.format(receiptDate);
        System.out.println(formattedDate);
        System.out.println("ID\t" + "Customer Name");
        System.out.println("----------------------------------");
        System.out.println(customer.getCustomerString());
        System.out.println("==================================");
        System.out.println("Prod ID" + "  Description\t" + "Qty\t" + "Unit Price\t" + "Subtotal\t" + "Discount");

        for (LineItem lineItem : lineItems) {
            System.out.println(lineItem.getLineItem());
        }

        System.out.println();

        //changes the output into a currency format
        DecimalFormat moneyFormat = new DecimalFormat("$0.00");

        System.out.println("Total Before Discount: \t" + moneyFormat.format(getTotalBeforeDiscount()));

        System.out.println("Total After Discount: \t" + moneyFormat.format(getTotalAfterDiscount()));

        System.out.println("You saved: " + moneyFormat.format(getTotalBeforeDiscount() - getTotalAfterDiscount()));

        System.out.println("\n\n");

    }

}
