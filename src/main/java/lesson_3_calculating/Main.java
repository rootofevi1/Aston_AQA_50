package lesson_3_calculating;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<>();

        Circle circle = new Circle(5.0, "Red", "Blue");
        shapes.add(circle);

        Rectangle rectangle = new Rectangle(4.0, 6.0, "Green", "Black");
        shapes.add(rectangle);

        Triangle triangle = new Triangle(3.0, 4.0, 5.0, "Yellow", "Orange");
        shapes.add(triangle);

        System.out.println("Information about all shapes:");
        for (Shape shape : shapes) {
            shape.displayInfo();
        }
    }
}
