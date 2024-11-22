
import java.util.ArrayList;
import java.util.List;

public class CompositeDiscount implements DiscountStrategy {
    private final List<DiscountStrategy> discounts = new ArrayList<>();

    public void addDiscount(DiscountStrategy discount) {
        discounts.add(discount);
    }

    @Override
    public double applyDiscount(double totalAmount) {
        double discountedAmount = totalAmount;
        for (DiscountStrategy discount : discounts) {
            discountedAmount = discount.applyDiscount(discountedAmount);
        }
        return discountedAmount;
    }
}
