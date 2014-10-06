package newdiscountstrategy;

public interface DiscountStrategy {

    public abstract double getDiscount(double cost, int qty);
        
    // rate = discount rate
    public abstract double getRate();

    public abstract void setRate(double rate);

}
