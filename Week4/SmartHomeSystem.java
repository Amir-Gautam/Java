class Device {
    String deviceName;

    Device(String deviceName) {
        this.deviceName = deviceName;
    }

    void operate() {
        System.out.println(deviceName + " is operating.");
    }
}

class Light extends Device {
    Light(String deviceName) {
        super(deviceName);
    }

    @Override
    void operate() {
        System.out.println(deviceName + " turns on, lighting up the room.");
    }
}

class Thermostat extends Device {
    private int temperature;

    Thermostat(String deviceName, int temperature) {
        super(deviceName);
        this.temperature = temperature;
    }

    @Override
    void operate() {
        System.out.println(deviceName + " sets the temperature to " + temperature + " degrees.");
    }
}

class SecurityCamera extends Device {
    SecurityCamera(String deviceName) {
        super(deviceName);
    }

    @Override
    void operate() {
        System.out.println(deviceName + " starts recording the surroundings.");
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        Device[] devices = {
            new Light("Living Room Light"),
            new Thermostat("Main Thermostat", 22),
            new SecurityCamera("Front Door Camera")
        };

        for (Device device : devices) {
            device.operate();
        }
    }
}
