package newdiscountstrategy;

public interface DiscountStrategy {

    public abstract double getDiscount(double cost, int qty);

    public abstract double getRate();

    public abstract void setRate(double rate);

}
