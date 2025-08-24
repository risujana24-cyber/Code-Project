
abstract class Shape {
    // Abstract method to calculate area
    public abstract double calculateArea();
}
class Circle extends Shape {
    private double radius; // Encapsulated field

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be a positive value.");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive values.");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}


class ShapeDemo {
    public static void main(String[] args) {
        try {
            Circle circle = new Circle(5.0);
            System.out.println("Area of Circle: " + circle.calculateArea());

            Rectangle rectangle = new Rectangle(4.0, 6.0);
            System.out.println("Area of Rectangle: " + rectangle.calculateArea());

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}