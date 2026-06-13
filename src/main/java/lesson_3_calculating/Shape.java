package lesson_3_calculating;

public interface Shape extends Colorable {

    double getArea();
    double getPerimeter();

    default double calculatePerimeter() {
        return getPerimeter();
    }

    default double calculateArea() {
        return getArea();
    }

    default void displayInfo() {
        System.out.println("=========================================");
        System.out.println("Shape: " + this.getClass().getSimpleName());
        System.out.printf("Area: %.2f%n", calculateArea());
        System.out.printf("Perimeter: %.2f%n", calculatePerimeter());
        System.out.println("Fill color: " + getFillColor());
        System.out.println("Border color: " + getBorderColor());
        System.out.println("=========================================");
    }
}
