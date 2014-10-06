package newdiscountstrategy;

import java.text.DecimalFormat;

public class LineItem {

    private Product product;
    private int qty;
    private final String BAD_ENTRY_MSG = "Error: invalid entry";

    public LineItem(String prodID, int qty, StoreDatabase db) {
        if (prodID == null || prodID.length() == 0 || qty < 0) {
            throw new IllegalArgumentException(BAD_ENTRY_MSG);
        }

        product = db.findProduct(prodID);
        this.qty = qty;

    }

    /**
     * Used to get the unit cost of an item
     *
     * @return unitCost
     */
    public final double getUnitCost() {

        return product.getUnitCost();
    }

    /**
     * Used to get the subtotal of the lineItem
     *
     * @return subtotal
     */
    public final double getSubTotal() {

        double subTotal = (product.getUnitCost() * qty) - product.getDiscount(qty);
        return subTotal;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        
        this.qty = qty;
    }

    public final String getLineItem() {
        String id = product.getProdID();
        String name = product.getProdName();
        double price = product.getUnitCost();
        double subTotal = getSubTotal();
        double discount = product.getDiscount(qty);

        DecimalFormat moneyFormat = new DecimalFormat("$0.00");
        return id + " " + name + "\t" + qty + "\t" + moneyFormat.format(price) + "\t\t" + moneyFormat.format(subTotal) + "\t\t" + moneyFormat.format(discount);

    }

}
