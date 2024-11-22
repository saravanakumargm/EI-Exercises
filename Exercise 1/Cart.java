
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<Product, Integer> items = new HashMap<>();
    private DiscountStrategy discountStrategy;

    public void addProduct(Product product, int quantity) {
        items.put(product.clone(), items.getOrDefault(product, 0) + quantity);
    }

    public void updateQuantity(Product product, int quantity) {
        if (items.containsKey(product)) {
            items.put(product, quantity);
        }
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public void applyDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }

        if (discountStrategy != null) {
            total = discountStrategy.applyDiscount(total);
        }

        return total;
    }

    public void displayCart() {
        System.out.println("Cart:");
        items.forEach((product, quantity) -> System.out.println(quantity + " x " + product.getName() + " - $" + (product.getPrice() * quantity)));
    }
}
