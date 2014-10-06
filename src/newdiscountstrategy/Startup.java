package newdiscountstrategy;

public class Startup {
//          "100", "Smith, John"
//          "200", "Anderson, Daniel"
//          "300", "Leonard, Jake"

//         Product("A101", "Baseball Cap")
//         Product("B205", "Men's Dress Shirt")
//         Product("C222", "Men's Socks")
//         Product("D333", "Mens Watch")
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CashRegister register1 = new CashRegister(new FakeDatabase());
        

        register1.startTransaction("300");
        register1.addItemToSale("A101", 1);
        register1.addItemToSale("B205", 2);
        register1.addItemToSale("C222", 5);
        
        
        register1.finalizeSale();
        
    }
}
