package lesson_7_junit_5;

public class TriangleAreaCalculator {

    public static double calculateArea(double a, double b, double c) {
        // Проверка на отрицательные стороны
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("All sides must be positive: a=" + a + ", b=" + b + ", c=" + c);
        }

        // Проверка на существование треугольника (неравенство треугольника)
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException(
                    "Triangle inequality violated: " + a + ", " + b + ", " + c
            );
        }

        // Полупериметр
        double s = (a + b + c) / 2.0;

        // Формула Герона: √(s(s-a)(s-b)(s-c))
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        return area;
    }
}
