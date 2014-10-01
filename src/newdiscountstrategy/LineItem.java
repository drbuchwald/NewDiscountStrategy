package newdiscountstrategy;

public class LineItem {

    private Product product;
    private int qty;

    public LineItem(String prodID, int qty) {
        if (prodID == null || prodID.length() == 0 || qty < 0) {
            System.out.println("Error: invalid entry");
            return;
        }
        FakeDatabase db = new FakeDatabase();
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
        //validation needed
        this.qty = qty;
    }

    public final String getLineItem() {
        String id = product.getProdID();
        String name = product.getProdName();
        double price = product.getUnitCost();
        double subTotal = getSubTotal();
        double discount = product.getDiscount(qty);

        return id + " " + name + "\t" + qty + "\t" + "$" + price + "\t\t" + "$" + subTotal + "\t\t" + discount;

    }

}
