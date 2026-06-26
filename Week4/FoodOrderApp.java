class FoodItem {
    private String name;
    private double price;

    FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    void displayMenuItem() {
        System.out.println(name + " - Rs. " + price);
    }
}

class Pizza extends FoodItem {
    private String size;
    private String[] toppings;

    Pizza(String name, double price, String size, String[] toppings) {
        super(name, price);
        this.size = size;
        this.toppings = toppings;
    }

    @Override
    void displayMenuItem() {
        System.out.println(getName() + " (" + size + ") - Rs. " + getPrice() + " | Toppings: " + String.join(", ", toppings));
    }
}

class Burger extends FoodItem {
    private boolean cheese;
    private String pattyType;

    Burger(String name, double price, boolean cheese, String pattyType) {
        super(name, price);
        this.cheese = cheese;
        this.pattyType = pattyType;
    }

    @Override
    void displayMenuItem() {
        System.out.println(getName() + " - Rs. " + getPrice() + " | Patty: " + pattyType + " | Cheese: " + (cheese ? "Yes" : "No"));
    }
}

class Salad extends FoodItem {
    private String[] ingredients;

    Salad(String name, double price, String[] ingredients) {
        super(name, price);
        this.ingredients = ingredients;
    }

    @Override
    void displayMenuItem() {
        System.out.println(getName() + " - Rs. " + getPrice() + " | Ingredients: " + String.join(", ", ingredients));
    }
}

public class FoodOrderApp {
    public static void main(String[] args) {
        FoodItem[] menu = {
            new Pizza("Newari Special Pizza", 650, "Large", new String[]{"Cheese", "Choila", "Onion"}),
            new Burger("Yak Cheese Burger", 350, true, "Buff"),
            new Salad("Himalayan Garden Salad", 180, new String[]{"Lettuce", "Cucumber", "Carrot"})
        };

        for (FoodItem item : menu) {
            item.displayMenuItem();
        }
    }
}
