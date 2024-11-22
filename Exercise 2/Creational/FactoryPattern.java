package Creational;

// interface for Pizza
interface Pizza {
    void prepare();  // Method to prepare the pizza
    void bake();     // Method to bake the pizza
    void box();      // Method to box the pizza
}

//Concrete classes implementing the Pizza interface

// CheesePizza class implements Pizza
class CheesePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Pizza.");
    }

    @Override
    public void bake() {
        System.out.println("Baking Cheese Pizza.");
    }

    @Override
    public void box() {
        System.out.println("Boxing Cheese Pizza.");
    }
}

// VeggiePizza class implements Pizza
class VeggiePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing Veggie Pizza.");
    }

    @Override
    public void bake() {
        System.out.println("Baking Veggie Pizza.");
    }

    @Override
    public void box() {
        System.out.println("Boxing Veggie Pizza.");
    }
}

// PepperoniPizza class implements Pizza
class PepperoniPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing Pepperoni Pizza.");
    }

    @Override
    public void bake() {
        System.out.println("Baking Pepperoni Pizza.");
    }

    @Override
    public void box() {
        System.out.println("Boxing Pepperoni Pizza.");
    }
}
class PizzaFactory {
    // Factory method to create and return a specific pizza type based on the input
    public Pizza getPizza(String pizzaType) {
        if (pizzaType == null) {
            return null;
        }
        if (pizzaType.equalsIgnoreCase("Cheese")) {
            return new CheesePizza();  // Return a CheesePizza object
        } else if (pizzaType.equalsIgnoreCase("Veggie")) {
            return new VeggiePizza();  // Return a VeggiePizza object
        } else if (pizzaType.equalsIgnoreCase("Pepperoni")) {
            return new PepperoniPizza();  // Return a PepperoniPizza object
        }
        return null;
    }
}

// Client
public class FactoryPattern {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactory();

        //factory to create different pizzas based on input
        Pizza pizza1 = pizzaFactory.getPizza("Cheese");
        pizza1.prepare();  // Preparing Cheese Pizza
        pizza1.bake();     // Baking Cheese Pizza
        pizza1.box();      // Boxing Cheese Pizza

        Pizza pizza2 = pizzaFactory.getPizza("Veggie");
        pizza2.prepare();  // Preparing Veggie Pizza
        pizza2.bake();     // Baking Veggie Pizza
        pizza2.box();      // Boxing Veggie Pizza

        Pizza pizza3 = pizzaFactory.getPizza("Pepperoni");
        pizza3.prepare();  // Preparing Pepperoni Pizza
        pizza3.bake();     // Baking Pepperoni Pizza
        pizza3.box();      // Boxing Pepperoni Pizza
    }
}

/*
The Factory Design Pattern in this example is used to create different types of
pizzas (CheesePizza, VeggiePizza, PepperoniPizza) based on the customer's selection.
It centralizes the creation logic in a factory class, allowing for easy addition of new pizza
types without changing existing code. This pattern provides flexibility and promotes loose
coupling between the client and the pizza creation process.
 */