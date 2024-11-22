
import java.util.HashMap;
import java.util.Map;

public class StockManager {
    private final Map<Product, Integer> stockLevels = new HashMap<>();

    public void addStock(Product product, int quantity) {
        stockLevels.put(product, stockLevels.getOrDefault(product, 0) + quantity);
    }

    public boolean isAvailable(Product product, int quantity) {
        return stockLevels.getOrDefault(product, 0) >= quantity;
    }

    public void reduceStock(Product product, int quantity) {
        if (isAvailable(product, quantity)) {
            stockLevels.put(product, stockLevels.get(product) - quantity);
        } else {
            throw new IllegalStateException("Insufficient stock for " + product.getName());
        }
    }

    public void displayStock() {
        System.out.println("Stock Levels:");
        stockLevels.forEach((product, quantity) -> System.out.println(product.getName() + ": " + quantity + " units available"));
    }
}
