package Creational;
// Singleton Class: Logger
class Logger {
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
        System.out.println("Logger initialized.");
    }

    // Public method to provide access to the single instance
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) { // Double-checked locking for performance
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

// Client
public class SingletonPattern {
    public static void main(String[] args) {
        // Get the Logger instance
        Logger logger1 = Logger.getInstance();
        logger1.log("Application started.");

        // Get the instance again and log another message
        Logger logger2 = Logger.getInstance();
        logger2.log("User logged in.");

        // Verify that both instances are the same
        System.out.println("\nAre both logger instances the same? " + (logger1 == logger2));
    }
}

/*
This program demonstrates the Singleton Design Pattern through a ConfigurationManager
that loads and shares configuration settings across the application. The Singleton ensures
that the configuration is loaded only once and accessed globally.
It prevents redundant loading and ensures consistency of configuration values throughout
the application.
 */
