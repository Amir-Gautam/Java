class Vehicle {
    String plateNumber;
    double baseRate;

    Vehicle(String plateNumber, double baseRate) {
        this.plateNumber = plateNumber;
        this.baseRate = baseRate;
    }

    double calculateRental(int days) {
        return baseRate * days;
    }
}

class Car extends Vehicle {
    Car(String plateNumber, double baseRate) {
        super(plateNumber, baseRate);
    }

    @Override
    double calculateRental(int days) {
        return baseRate * days;
    }
}

class Truck extends Vehicle {
    private double loadFee;

    Truck(String plateNumber, double baseRate, double loadFee) {
        super(plateNumber, baseRate);
        this.loadFee = loadFee;
    }

    @Override
    double calculateRental(int days) {
        return (baseRate * days) + loadFee;
    }
}

class Bike extends Vehicle {
    private double fixedRate;

    Bike(String plateNumber, double baseRate, double fixedRate) {
        super(plateNumber, baseRate);
        this.fixedRate = fixedRate;
    }

    @Override
    double calculateRental(int days) {
        return fixedRate;
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("Ba 2 Pa 4521", 1500),
            new Truck("Ba 5 Kha 1187", 2500, 1000),
            new Bike("Ba 12 Ja 0098", 500, 800)
        };

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.plateNumber + " rental for 3 days: Rs. " + vehicle.calculateRental(3));
        }
    }
}
