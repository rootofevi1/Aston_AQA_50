package lesson_7_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaCalculatorTest {

    private static final double DELTA = 0.0001;

    @Test
    @DisplayName("Площадь треугольника 3,4,5 = 6 (прямоугольный)")
    void areaOfTriangleWithSides345() {
        assertEquals(6.0, TriangleAreaCalculator.calculateArea(3, 4, 5), DELTA,
                "Площадь 3,4,5 = 6");
    }

    @Test
    @DisplayName("Площадь треугольника 2,2,2 = √3 (равносторонний)")
    void areaOfEquilateralTriangle() {
        double expected = Math.sqrt(3);
        assertEquals(expected, TriangleAreaCalculator.calculateArea(2, 2, 2), DELTA,
                "Площадь 2,2,2 = √3 ≈ 1.732");
    }

    @Test
    @DisplayName("Площадь треугольника 5,5,6 = 12 (равнобедренный)")
    void areaOfIsoscelesTriangle() {
        assertEquals(12.0, TriangleAreaCalculator.calculateArea(5, 5, 6), DELTA,
                "Площадь 5,5,6 = 12");
    }

    @Test
    @DisplayName("Площадь треугольника 1,1,1.999 = <0,5 (почти вырожденный)")
    void areaOfAlmostDegenerateTriangle() {
        double area = TriangleAreaCalculator.calculateArea(1, 1, 1.999);
        assertTrue(area > 0 && area < 0.5,
                "Площадь почти вырожденного треугольника < 0,5");
    }

    @Test
    @DisplayName("Сторона 0 должна выбросить исключение")
    void sideZeroShouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateArea(0, 4, 5),
                "Сторона 0 должна вызывать IllegalArgumentException");
    }

    @Test
    @DisplayName("Отрицательная сторона должна выбросить исключение")
    void negativeSideShouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateArea(-3, 4, 5),
                "Отрицательная сторона должна вызывать IllegalArgumentException");
    }

    @Test
    @DisplayName("Нарушение неравенства треугольника (a + b < c)")
    void invalidTriangleSumLess() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateArea(1, 1, 3),
                "1 + 1 < 3 → не треугольник");
    }

    @Test
    @DisplayName("Вырожденный треугольник (a + b == c)")
    void degenerateTriangleShouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateArea(1, 2, 3),
                "1 + 2 = 3 → вырожденный треугольник");
    }
}
