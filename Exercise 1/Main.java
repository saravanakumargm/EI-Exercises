
public class Main {
    public static void main(String[] args) throws Exception {
        // Initialize StockManager
        StockManager stockManager = new StockManager();

        // Create products and add stock
        Product laptop = new Electronics("Laptop", 1000, true);
        Product headphones = new Electronics("Headphones", 50, true);

        stockManager.addStock(laptop, 10);
        stockManager.addStock(headphones, 20);

        // Display initial stock levels
        stockManager.displayStock();

        // Create cart
        Cart cart = new Cart(stockManager);

        // Add products to cart
        cart.addProduct(laptop, 2);
        cart.addProduct(headphones, 1);
        cart.updateQuantity(laptop,3);

        // Apply multiple discounts
        CompositeDiscount compositeDiscount = new CompositeDiscount();
        compositeDiscount.addDiscount(new PercentageDiscount(10)); // 10% off
        compositeDiscount.addDiscount(new BuyOneGetOneFreeDiscount(headphones, 1)); // BOGO on headphones

        cart.applyDiscountStrategy(compositeDiscount);

        // Display cart and total
        cart.displayCart();
        System.out.println("Total Bill: ₹" + cart.calculateTotal());

        // Display final stock levels
        stockManager.displayStock();
    }
}
