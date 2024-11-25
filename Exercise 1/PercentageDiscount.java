public class PercentageDiscount implements DiscountStrategyInterface {
    private final double percentage;

    public PercentageDiscount(double percentage) throws Exception {
        if(percentage>100){
            throw new Exception("Invalid Number");
        }
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount - (totalAmount * percentage / 100);
    }
}
