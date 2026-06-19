abstract class Shape {
    abstract double calculateArea();
}

class Rectangle extends Shape {
    private double length;
    private double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Rectangle(5, 4),
            new Circle(3),
            new Triangle(6, 8)
        };

        double totalArea = 0;
        for (Shape shape : shapes) {
            double area = shape.calculateArea();
            System.out.println(shape.getClass().getSimpleName() + " area: " + area);
            totalArea += area;
        }

        System.out.println("Total area: " + totalArea);
    }
}
