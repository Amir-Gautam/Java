class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void displayDetails() {
        System.out.println(name + " - Rs. " + price);
    }
}

class Electronics extends Product {
    private int warrantyPeriod;

    Electronics(String name, double price, int warrantyPeriod) {
        super(name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    void displayDetails() {
        System.out.println(name + " - Rs. " + price + " | Warranty: " + warrantyPeriod + " months");
    }
}

class Clothing extends Product {
    private String size;
    private String material;

    Clothing(String name, double price, String size, String material) {
        super(name, price);
        this.size = size;
        this.material = material;
    }

    @Override
    void displayDetails() {
        System.out.println(name + " - Rs. " + price + " | Size: " + size + " | Material: " + material);
    }
}

class Grocery extends Product {
    private String expiryDate;

    Grocery(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    void displayDetails() {
        System.out.println(name + " - Rs. " + price + " | Expires: " + expiryDate);
    }
}

public class ProductCatalog {
    public static void main(String[] args) {
        Product[] products = {
            new Electronics("Walton Smart TV", 35000, 24),
            new Clothing("Dhaka Topi", 850, "Free Size", "Cotton Blend"),
            new Grocery("Mustang Apple (1kg)", 250, "2026-07-01")
        };

        for (Product product : products) {
            product.displayDetails();
        }
    }
}
