# Structural Design Patterns

This folder contains implementations of various structural design patterns. Each pattern is demonstrated through a different example, showing its application and benefits

## 1. Adapter Pattern - USB Connection Application
This program demonstrates the Adapter Pattern by enabling compatibility between two interfaces: USB Type-B and USB Type-C. An UsbAdapter class bridges the gap by adapting UsbTypeBDevice to be used as a UsbTypeC device. This approach allows seamless interaction between incompatible interfaces without altering their implementations.

  * **Target Interface**: USBTypeB, USBTypeC
  * **Adaptee**: USBTypeBDevice, USBTypeCDevice
  * **Adapter**: USBAdapter
  * **Client**: AdapterPattern.java

## 2. Facade Pattern - Home Theatre System
This program demonstrates the Facade Design Pattern by creating a HomeTheaterFacade to simplify interactions with multiple subsystems like DVD Player, Projector, Amplifier, and Theater Lights. The facade provides a unified interface to perform complex operations like starting and shutting down the home theater system. This approach enhances usability by hiding the complexity of subsystem interactions from the client.

  * **SubSystems**: DVDPlayer, Projector, Amplifier, Lights
  * **Facade**: HomeTheatreFacade
  * **Client**: FacadePattern.java

## 3. Proxy Pattern - Banking Application
This program demonstrates the Proxy Design Pattern through a BankAccountProxy that controls access to a RealBankAccount based on user roles. The proxy restricts sensitive operations like withdrawing money and viewing the balance for unauthorized users. This approach adds an extra layer of security while maintaining the same interface for clients.

  * **Subject Interface**: BankAccount
  * **Real Subject**: RealBankAccount
  * **Proxy**: BankAccountProxy
  * **Client**: ProxyPattern.java
