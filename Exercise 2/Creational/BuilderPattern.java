//Product class - Car
class Car {
    private String engine;
    private String transmission;
    private String color;
    private boolean hasSunroof;
    private boolean hasGPS;

    // Private constructor to restrict direct object creation
    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.transmission = builder.transmission;
        this.color = builder.color;
        this.hasSunroof = builder.hasSunroof;
        this.hasGPS = builder.hasGPS;
    }


    public String getEngine() {
        return engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getColor() {
        return color;
    }

    public boolean hasSunroof() {
        return hasSunroof;
    }

    public boolean hasGPS() {
        return hasGPS;
    }

    //Static nested Builder class
    public static class CarBuilder {
        private String engine;
        private String transmission;
        private String color;
        private boolean hasSunroof;
        private boolean hasGPS;

        // Builder methods for setting up car attributes
        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setTransmission(String transmission) {
            this.transmission = transmission;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder addSunroof(boolean hasSunroof) {
            this.hasSunroof = hasSunroof;
            return this;
        }

        public CarBuilder addGPS(boolean hasGPS) {
            this.hasGPS = hasGPS;
            return this;
        }

        // Final build method to create the Car object
        public Car build() {
            return new Car(this);
        }
    }
}

//Client
public class BuilderPattern {
    public static void main(String[] args) {
        //Car with engine, transmission, color, and additional features
        Car car1 = new Car.CarBuilder()
                .setEngine("V8")
                .setTransmission("Automatic")
                .setColor("Red")
                .addSunroof(true)
                .addGPS(true)
                .build();

        // Create a car with different options
        Car car2 = new Car.CarBuilder()
                .setEngine("V6")
                .setTransmission("Manual")
                .setColor("Blue")
                .addSunroof(false)
                .addGPS(true)
                .build();

        // Output
        System.out.println("Car 1: ");
        System.out.println("Engine: " + car1.getEngine());
        System.out.println("Transmission: " + car1.getTransmission());
        System.out.println("Color: " + car1.getColor());
        System.out.println("Has Sunroof: " + car1.hasSunroof());
        System.out.println("Has GPS: " + car1.hasGPS());

        System.out.println("\nCar 2: ");
        System.out.println("Engine: " + car2.getEngine());
        System.out.println("Transmission: " + car2.getTransmission());
        System.out.println("Color: " + car2.getColor());
        System.out.println("Has Sunroof: " + car2.hasSunroof());
        System.out.println("Has GPS: " + car2.hasGPS());
    }
}

/*
This code creates a complex Car object with various options such as engine type, transmission,
color, and features. It provides a step-by-step approach to constructing the car,
allowing different configurations while ensuring the integrity of the object.
This pattern improves flexibility and maintainability by decoupling the construction process
from the actual car object.
 */
