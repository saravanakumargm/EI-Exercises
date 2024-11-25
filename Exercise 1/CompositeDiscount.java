
import java.util.ArrayList;
import java.util.List;

public class CompositeDiscount implements DiscountStrategyInterface {
    private final List<DiscountStrategyInterface> discounts = new ArrayList<>();

    public void addDiscount(DiscountStrategyInterface discount) {
        discounts.add(discount);
    }

    @Override
    public double applyDiscount(double totalAmount) {
        double discountedAmount = totalAmount;
        for (DiscountStrategyInterface discount : discounts) {
            discountedAmount = discount.applyDiscount(discountedAmount);
        }
        return discountedAmount;
    }
}
