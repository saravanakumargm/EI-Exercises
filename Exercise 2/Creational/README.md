# **Creational Design Patterns**

This folder contains implementations of various creational design patterns. Each pattern is demonstrated through a different example, showing its application and benefits.

## **1. Builder Pattern - Car Manufacuring Application**
The Builder Pattern is used to construct complex objects step-by-step. In this example a simple car manufacturer application that builds cars with various components such as engine, transmission, color, sunroof and GPS.The pattern provides a flexible way to create cars by allowing incremental construction and ensuring immutability of the final object.

  * **Product**: Car
  * **Builder**: CarBuilder
  * **Client** BuilderPattern.java

## **2. Factory Pattern - Pizza Factory Application**
The Factory Pattern provides an interface for creating objects without specifying the exact class of object that will be created. This implementation includes a factory that creates instances of different pizzas, encapsulating the object creation logic and providing a clean interface for object creation.

  * **Product Inteface**: Pizza
  * **Concrete Products**: CheesePizza, VeggiePizza, PepperoniPizza
  * **Factory**: PizzaFactory
  * **Client**: Factorypattern.java
    
## **3.Singleton Pattern - Logger Application**
The Logger Singleton example demonstrates the Singleton design pattern by ensuring only one instance of the Logger class exists throughout the application. It provides a global point of access to log messages, maintaining consistency in logging across different components. This approach reduces redundancy and prevents the creation of multiple logging instances.

  * **Singleton Class**: Logger
  * **Client**: SingletonPattern.java
