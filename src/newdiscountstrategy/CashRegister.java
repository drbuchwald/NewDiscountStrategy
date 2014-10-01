package newdiscountstrategy;

public class CashRegister {

    private Receipt receipt;

    public CashRegister() {
        this.receipt = new Receipt();
    }

    /**
     * Used to add an item to the sale
     *
     * @param prodID a product ID
     * @param qty The quantity of items to add
     */
    public final void addItemToSale(String prodID, int qty) {
        if (prodID == null || prodID.length() == 0 || qty < 0) {
            System.out.println("Invalid entry");
            return;
        }
        receipt.addItem(prodID, qty);

    }

    /**
     * Used to start a sale for a particular customer
     *
     * @param custID a customer ID number
     */
    public final void startTransaction(String custID) {
        if (custID == null || custID.length() == 0) {
            System.out.println("Invalid entry");
            return;
        }
        receipt.addCustomer(custID);
    }

    /**
     * used at the end of the sale to finalize the transaction
     */
    public final void finalizeSale() {

        receipt.generateReceipt();
    }

}
