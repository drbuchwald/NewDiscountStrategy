package newdiscountstrategy;

public class Customer {

    private String customerID;
    private String name;
    private final String BAD_ENTRY_MSG = "Error: invalid entry";
    
    
    public Customer(String customerID, String name) {
        if (customerID == null || customerID.length() == 0 || name == null || name.length() == 0) {

            throw new IllegalArgumentException(BAD_ENTRY_MSG);
        }
        this.customerID = customerID;
        this.name = name;
    }

    /**
     * gets the customer ID
     *
     * @return the customer ID String
     */
    public final String getCustomerID() {
        return customerID;
    }

    /**
     * sets the customer ID
     *
     * @param customerID a String containing the customer ID
     */
    public final void setCustomerID(String customerID) {
        if (customerID == null || customerID.length() == 0) {

            throw new IllegalArgumentException(BAD_ENTRY_MSG);
        }
        this.customerID = customerID;
    }

    /**
     * get customer name
     *
     * @return customer name as a string
     */
    public final String getName() {
        return name;
    }

    /**
     * set the customer name
     *
     * @param name a string containing the customer name
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * used to get a String containing the customer ID and customer name
     *
     * @return customerString
     */
    public final String getCustomerString() {

        String customerString = customerID + " " + name;
        return customerString;
    }

}
