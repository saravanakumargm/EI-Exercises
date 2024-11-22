
public class Main {
    public static void main(String[] args) throws Exception {
        // Create products
        Product laptop = new Electronics("Laptop", 1000, true);
        Product headphones = new Electronics("Headphones", 50, true);

        // Create a cart
        Cart cart = new Cart();

        // Add products to the cart
        cart.addProduct(laptop, 1);
        cart.addProduct(headphones, 1);

        // Update quantities
        cart.updateQuantity(laptop, 2);

        // Apply a 10% discount
        cart.applyDiscountStrategy(new PercentageDiscount(10));

        // Display cart and total
        cart.displayCart();
        System.out.println("Total Bill: $" + cart.calculateTotal());
    }
}
