package newdiscountstrategy;

public class VariableRateDiscount implements DiscountStrategy {

    private double rate = .10;

    public VariableRateDiscount() {
    }

    public VariableRateDiscount(double rate) {

        setRate(rate);
    }

    @Override
    public final double getDiscount(double cost, int qty) {

        return cost * qty * rate;
    }

    @Override
    public final double getRate() {
        return rate;
    }

    @Override
    public final void setRate(double rate) {

        this.rate = rate;
    }

}
