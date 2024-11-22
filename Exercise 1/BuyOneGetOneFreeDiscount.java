
public class BuyOneGetOneFreeDiscount implements DiscountStrategy {
    private final Product product;
    private final int quantity;

    public BuyOneGetOneFreeDiscount(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        int freeItems = quantity / 2;
        double discount = freeItems * product.getPrice();
        return totalAmount - discount;
    }
}
