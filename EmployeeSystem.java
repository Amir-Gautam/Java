class Employee {
    private String name;
    private String id;
    private double baseSalary;

    Employee(String name, String id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    double getBaseSalary() {
        return baseSalary;
    }

    String getName() {
        return name;
    }

    String getId() {
        return id;
    }

    double calculateSalary() {
        return baseSalary;
    }
}

class Manager extends Employee {
    private double bonus;

    Manager(String name, String id, double baseSalary, double bonus) {
        super(name, id, baseSalary);
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}

class Developer extends Employee {
    private double overtimeHours;
    private double rate;

    Developer(String name, String id, double baseSalary, double overtimeHours, double rate) {
        super(name, id, baseSalary);
        this.overtimeHours = overtimeHours;
        this.rate = rate;
    }

    @Override
    double calculateSalary() {
        return getBaseSalary() + (overtimeHours * rate);
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        Manager manager = new Manager("Sunita Adhikari", "M001", 50000, 12000);
        Developer developer = new Developer("Bibek Shrestha", "D001", 40000, 10, 250);

        System.out.println(manager.getName() + " salary: Rs. " + manager.calculateSalary());
        System.out.println(developer.getName() + " salary: Rs. " + developer.calculateSalary());
    }
}
