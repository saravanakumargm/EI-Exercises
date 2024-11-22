package Structural;

// USB Type-B Interface
interface UsbTypeB {
    void connectWithUsbTypeB();
}

// USB Type-C Interface
interface UsbTypeC {
    void connectWithUsbTypeC();
}

// Implementation of USB Type-B device
class UsbTypeBDevice implements UsbTypeB {
    @Override
    public void connectWithUsbTypeB() {
        System.out.println("Connected with USB Type-B device.");
    }
}

// Implementation of USB Type-C device
class UsbTypeCDevice implements UsbTypeC {
    @Override
    public void connectWithUsbTypeC() {
        System.out.println("Connected with USB Type-C device.");
    }
}

// Adapter class that adapts USB Type-B to USB Type-C
class UsbAdapter implements UsbTypeC {
    private UsbTypeB usbTypeBDevice;

    // Constructor to accept a USB Type-B device
    public UsbAdapter(UsbTypeB usbTypeBDevice) {
        this.usbTypeBDevice = usbTypeBDevice;
    }

    @Override
    public void connectWithUsbTypeC() {
        System.out.println("Adapter converting USB Type-B to USB Type-C...");
        usbTypeBDevice.connectWithUsbTypeB();
    }
}

// Client
public class AdapterPattern {
    public static void main(String[] args) {
        // USB Type-B device
        UsbTypeB usbTypeBDevice = new UsbTypeBDevice();

        // Using an adapter to connect a USB Type-B device to a USB Type-C interface
        UsbTypeC usbTypeCDevice = new UsbAdapter(usbTypeBDevice);

        // Connect via USB Type-C
        usbTypeCDevice.connectWithUsbTypeC();

        // Direct connection with USB Type-C device
        UsbTypeC typeCDevice = new UsbTypeCDevice();
        typeCDevice.connectWithUsbTypeC();
    }
}


/*
This program demonstrates the Adapter Pattern by enabling compatibility between
two interfaces: USB Type-B and USB Type-C. An UsbAdapter class bridges the gap by adapting
UsbTypeBDevice to be used as a UsbTypeC device. This approach allows seamless interaction
between incompatible interfaces without altering their implementations.
*/