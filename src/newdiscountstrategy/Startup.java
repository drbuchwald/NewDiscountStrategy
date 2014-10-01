package newdiscountstrategy;

public class Startup {
//          "100", "Smith, John"
//          "200", "Anderson, Daniel"
//          "300", "Leonard, Jake"

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CashRegister register1 = new CashRegister();

        register1.startTransaction("100");
        register1.addItemToSale("A101", 1);
        register1.addItemToSale("B205", 5);
        register1.addItemToSale("C222", 3);
        register1.finalizeSale();

    }
}
