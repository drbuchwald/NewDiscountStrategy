package newdiscountstrategy;

public class NoDiscount implements DiscountStrategy {

    @Override
    public double getDiscount(double cost, int qty) {
        return 0;
    }

    @Override
    public double getRate() {
        throw new UnsupportedOperationException("Not supported at this time.");
    }

    @Override
    public void setRate(double rate) {
        throw new UnsupportedOperationException("Not supported at this time.");
    }

}
