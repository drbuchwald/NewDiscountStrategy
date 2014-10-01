package newdiscountstrategy;

public class QuantityDiscount implements DiscountStrategy {

    private int minQty = 2;
    private double rate = .10;

    public QuantityDiscount() {
    }

    public QuantityDiscount(double rate, int minQty) {

        setMinQty(minQty);
        setRate(rate);

    }

    @Override
    public final double getDiscount(double cost, int qty) {

        if (qty >= minQty) {
            return cost * qty * rate;
        } else {
            return 0;
        }
    }

    @Override
    public final double getRate() {
        return rate;
    }

    @Override
    public final void setRate(double rate) {

        this.rate = rate;
    }

    public final int getMinQty() {
        return minQty;
    }

    public final void setMinQty(int minQty) {

        this.minQty = minQty;
    }

}
