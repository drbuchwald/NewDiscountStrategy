package newdiscountstrategy;

public class FakeDatabase implements StoreDatabase {

    private final String BAD_ENTRY_MSG = "Error: invalid entry";
    
    Product[] products = {
        new Product("A101", "Baseball Cap", 25, new VariableRateDiscount(.75)),
        new Product("B205", "Men's Dress Shirt", 100, new VariableRateDiscount(.25)),
        new Product("C222", "Men's Socks", 20, new QuantityDiscount(.15, 5)),
        new Product("D333", "Mens Watch", 120, new NoDiscount())
    };

    Customer[] customers = {
        new Customer("100", "Smith, John"),
        new Customer("200", "Anderson, Daniel"),
        new Customer("300", "Leonard, Jake")

    };

    /**
     * Used to find a product in the fake database from the product ID
     *
     * @param prodId a string containing the product ID
     * @return the product object
     */
    @Override
    public final Product findProduct(final String prodId) {
        if (prodId == null || prodId.length() == 0) {
            throw new IllegalArgumentException(BAD_ENTRY_MSG);
            
        }
        Product product = null;
        for (Product p : products) { //":" short-handed way to write a for-loop
            if (prodId.equals(p.getProdID())) {
                product = p;
                break; // break out of the loop
            }
        }

        return product;
    }

    /**
     * Used to find a customer in the fake database using the customer ID
     *
     * @param custID a string containing the customer ID
     * @return customer object
     */
    @Override
    public final Customer findCustomer(final String custID) {
        if (custID == null || custID.length() == 0) {

            throw new IllegalArgumentException(BAD_ENTRY_MSG);
            
        }
        Customer customer = null;
        for (Customer c : customers) {
            if (custID.equals(c.getCustomerID())) {
                customer = c;
                break;
            }
        }

        return customer;
    }

}
