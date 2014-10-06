/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newdiscountstrategy;

/**
 *
 * @author Dan
 */
public interface StoreDatabase {

    /**
     * Used to find a customer in the fake database using the customer ID
     *
     * @param custID a string containing the customer ID
     * @return customer object
     */
    Customer findCustomer(final String custID);

    /**
     * Used to find a product in the fake database from the product ID
     *
     * @param prodId a string containing the product ID
     * @return the product object
     */
    Product findProduct(final String prodId);
    
}
