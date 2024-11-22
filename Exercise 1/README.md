#**E-Commerce Cart System**

##**Problem Statement**

 Develop a simple E-commerce cart system where users can add products to their cart, update quantities, and view the total bill. Products 
should have attributes like name, price, and availability status

##**Project Overview**

This project implements a console-based E-Commerce Cart System with several advanced features:

* **Product Management:** Display a list of available products with attributes such as name, price, and stock availability.Ensure products are only added to the cart if sufficient stock is available.

* **Cart Operations:** Users can add products to the cart, update quantities, and remove items..Products are cloned using the Prototype Pattern to maintain immutability of the original product data.

* **Discount System:** Apply multiple discount strategies, such as percentage-based discounts or Buy One Get One Free offers, using the Strategy Pattern.Combine multiple discount strategies using the Composite Pattern for flexible discount management.

* **Stock Management:** Ensure accurate stock levels are maintained. Adding items to the cart reduces stock, while removing items restores stock levels.Notify users when attempting to add items with insufficient stock.

##**Project Structure**

1.  **Main.java**
This file contains the entry point for the application. The Main class provides a console-based user interface for interacting with the E-Commerce Cart System. Users can perform actions such as viewing available products, adding items to the cart, updating quantities, applying discounts, and viewing the total bill. It serves as the central controller for invoking functionalities.

2. **Product.java**
This file defines the Product class, which represents individual products in the system. It uses the Prototype Pattern to allow cloning of product objects when adding them to the cart. Key attributes of the Product class include:

  **Name:** The name of the product.

  **Price:** The cost of the product.

  **Availability:** A boolean indicating whether the product is in stock.

This class provides the foundation for creating specialized product types and supports immutability during cart operations.

3. **Electronics.java**
This file is a subclass of Product representing electronic products. It inherits from Product and can be extended further to include electronic-specific attributes, such as warranty periods or brand names.

4. **Cart.java**
The Cart class manages the shopping cart. It supports:

* **Adding products to the cart and cloning them using the Prototype Pattern.**
* **Updating quantities and removing items.**
* **Calculating the total bill, including discounts.**
* **Displaying cart contents in a user-friendly format.**
The cart interacts with the StockManager to ensure stock levels are maintained accurately during cart operations.

5. **StockManager.java**
The StockManager class is responsible for managing the stock of products. It maintains a map of products and their available quantities. Features include:

* **Adding stock for products.**
* **Checking stock availability for a given quantity.**
* **Adjusting stock levels when items are added to or removed from the cart.**
* **Displaying current stock levels.**
This class prevents overselling by validating stock levels before cart operations.

6. **DiscountStrategy.java**

This file contains the DiscountStrategy interface, which serves as the base for all discount strategies. It uses the Strategy Pattern to allow dynamic application of different discount types. The interface defines a single method:


**applyDiscount(double totalAmount): Applies a discount to the total bill and returns the discounted amount.**

7. **PercentageDiscount.java**
This file implements the DiscountStrategy interface. It applies a percentage-based discount to the total bill. Users can specify the percentage (e.g., 10% off) at the time of initialization.

8. **BuyOneGetOneFreeDiscount.java**
This file implements the DiscountStrategy interface to provide a Buy One Get One Free (BOGO) discount. It calculates the discount based on the number of eligible items in the cart and subtracts the cost of free items from the total.

9. **CompositeDiscount.java**
The CompositeDiscount class combines multiple discount strategies using the Composite Pattern. It allows stacking of discounts, such as combining a percentage-based discount with a BOGO offer. Users can add multiple discount strategies, and the total discount is applied sequentially.

10. **Logger.java**
The Logger class is implemented as a Singleton to ensure only one instance exists throughout the application. It logs all significant actions performed in the system, such as:

* **Adding products to the cart.**
* **Updating or removing items.**
* **Applying discounts.**
* **Calculating totals.**


##**How to Use the E-Commerce Cart System**

* **Run the Application:** Run the Main.java file to launch the console-based interface.
The program will display a list of available options.

* **View Available Products:** Choose the option to view all available products.The system will display product details, including name, price, and stock availability.

* **Add Products to the Cart:** Select the option to add products to the cart.Provide the product name and the desired quantity.If sufficient stock is available, the product will be added to the cart.
* **Update Cart Quantities:** Select the option to update quantities of items in the cart.Specify the product name and the new quantity.
The system will adjust the stock levels accordingly.

* **Remove Products from the Cart:** Choose the option to remove items from the cart.
Provide the product name to remove it entirely from the cart.The removed quantity will be restored to stock.

* **Apply Discounts:** Select the option to apply discounts.Choose from available discount strategies: Percentage-based discounts (e.g., 10% off).Buy One Get One Free (BOGO) offers.Stack multiple discounts for maximum savings using the Composite Discount feature.

* **View Cart and Total Bill:** Choose the option to display cart contents.The system will show all items in the cart with their quantities and subtotals.The total bill, including applied discounts, will be displayed.

* **Check Stock Levels:** View the current stock levels for all products.Ensure sufficient stock is available before adding items to the cart.

* **Review Logs:** View the system logs to see a record of all significant actions, including task additions, updates, and discounts applied.

* **Exit the Application:** Select the exit option to close the program.

##**Design Patterns Used**

1. **Singleton Pattern:** 
* Used in Logger to ensure only one instance of the Logger class exists throughout the application.Centralizes logging for all significant actions such as adding products, updating quantities, and applying discounts.

2. **Prototype Pattern:** Used In: Product
Allows cloning of Product objects when adding them to the cart, ensuring the immutability of the original product data.Prevents direct modifications to the original product instances while maintaining consistency in the cart.

3. **Strategy Pattern:** Used In: DiscountStrategy, PercentageDiscount, BuyOneGetOneFreeDiscount. Provides a flexible way to apply different discount strategies. Allows users to dynamically select or combine multiple strategies, such as percentage-based discounts or Buy One Get One Free offers.

4. **Composite Pattern:**
Used In: CompositeDiscount. Combines multiple discount strategies into a single, stackable discount.Enables users to maximize savings by applying a sequence of discounts in a structured and maintainable manner.

##**Summary**

The E-Commerce Cart System is a console-based application that allows users to manage their shopping cart by adding, updating, and removing products while maintaining accurate stock levels. It supports multiple discount strategies, such as percentage-based and Buy One Get One Free, and ensures traceability through a centralized logging system. Built with design patterns like Singleton, Strategy, and Prototype, the system is modular, extensible, and user-friendly.