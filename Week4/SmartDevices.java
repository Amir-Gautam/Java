class SmartDevice {
    String brand;
    String model;

    SmartDevice(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    void turnOn() {
        System.out.println(brand + " " + model + " is turning on.");
    }

    void turnOff() {
        System.out.println(brand + " " + model + " is turning off.");
    }
}

class SmartPhone extends SmartDevice {
    SmartPhone(String brand, String model) {
        super(brand, model);
    }

    @Override
    void turnOn() {
        System.out.println(brand + " " + model + " phone lights up and unlocks the home screen.");
    }

    @Override
    void turnOff() {
        System.out.println(brand + " " + model + " phone screen fades to black.");
    }
}

class SmartWatch extends SmartDevice {
    SmartWatch(String brand, String model) {
        super(brand, model);
    }

    @Override
    void turnOn() {
        System.out.println(brand + " " + model + " watch face glows and starts tracking your pulse.");
    }

    @Override
    void turnOff() {
        System.out.println(brand + " " + model + " watch goes into sleep mode.");
    }
}

public class SmartDevices {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartPhone("CG", "Mobile X1"),
            new SmartWatch("Ncell", "FitTrack Pro")
        };

        for (SmartDevice device : devices) {
            device.turnOn();
            device.turnOff();
        }
    }
}
