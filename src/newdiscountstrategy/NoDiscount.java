package newdiscountstrategy;

public class NoDiscount implements DiscountStrategy {

    private final String Not_Supported_Msg = "Not supported at this time.";
    
    @Override
    public double getDiscount(double cost, int qty) {
        return 0;
    }

    @Override
    public double getRate() {
        throw new UnsupportedOperationException(Not_Supported_Msg);
    }

    @Override
    public void setRate(double rate) {
        throw new UnsupportedOperationException(Not_Supported_Msg);
    }

}
