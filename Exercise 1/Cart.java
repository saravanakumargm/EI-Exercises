

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<Product, Integer> items = new HashMap<>();
    private DiscountStrategy discountStrategy;
    private final StockManager stockManager;

    public Cart(StockManager stockManager) {
        this.stockManager = stockManager;
    }

    public void addProduct(Product product, int quantity) {
        if (stockManager.isAvailable(product, quantity)) {
            items.put(product.clone(), items.getOrDefault(product, 0) + quantity);
            stockManager.reduceStock(product, quantity); // Update stock levels
        } else {
            System.out.println("Unable to add " + product.getName() + ": Not enough stock available.");
        }
    }

    public void updateQuantity(Product product, int quantity) {
        if (stockManager.isAvailable(product, quantity)) {
            int currentQuantity = items.getOrDefault(product, 0);
            int difference = quantity - currentQuantity;

            if (difference > 0) {
                stockManager.reduceStock(product, difference);
            } else {
                stockManager.addStock(product, -difference);
            }

            items.put(product, quantity);
        } else {
            System.out.println("Unable to update quantity for " + product.getName() + ": Not enough stock available.");
        }
    }

    public void removeProduct(Product product) {
        int quantity = items.getOrDefault(product, 0);
        if (quantity > 0) {
            stockManager.addStock(product, quantity); // Restore stock
            items.remove(product);
        }
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
        items.forEach((product, quantity) -> System.out.println(quantity + " x " + product.getName() + " - ₹" + (product.getPrice() * quantity)));
    }
}
