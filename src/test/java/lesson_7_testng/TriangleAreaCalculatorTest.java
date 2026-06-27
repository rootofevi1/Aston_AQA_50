package lesson_7_testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class TriangleAreaCalculatorTest {

    private static final double DELTA = 0.0001;

    @DataProvider(name = "positiveTriangleData")
    public Object[][] positiveTriangleData() {
        return new Object[][]{
                {3.0, 4.0, 5.0, 6.0, "Площадь 3,4,5 = 6 (прямоугольный)"},
                {2.0, 2.0, 2.0, Math.sqrt(3), "Площадь 2,2,2 = √3 (равносторонний)"},
                {5.0, 5.0, 6.0, 12.0, "Площадь 5,5,6 = 12 (равнобедренный)"}
        };
    }

    @DataProvider(name = "invalidSideData")
    public Object[][] invalidSideData() {
        return new Object[][]{
                {0.0, 4.0, 5.0, "Сторона 0, исключение"},
                {-3.0, 4.0, 5.0, "Отрицательная сторона, исключение"},
                {-1.0, -2.0, -3.0, "Все стороны отрицательные, исключение"}
        };
    }

    @DataProvider(name = "invalidTriangleData")
    public Object[][] invalidTriangleData() {
        return new Object[][]{
                {1.0, 1.0, 3.0, "1 + 1 < 3 → не треугольник (нарушение неравенства)"},
                {1.0, 2.0, 3.0, "1 + 2 = 3 → вырожденный треугольник"}
        };
    }

    @Test(
            dataProvider = "positiveTriangleData",
            description = "Проверка площади треугольника"
    )
    public void calculateAreaShouldReturnCorrectValue(double a, double b, double c, double expected, String description) {
        assertEquals(
                TriangleAreaCalculator.calculateArea(a, b, c),
                expected,
                DELTA,
                description
        );
    }

    @Test(description = "Площадь почти вырожденного треугольника (1,1,1.999) должна быть < 0,5")
    public void areaOfAlmostDegenerateTriangle() {
        double area = TriangleAreaCalculator.calculateArea(1, 1, 1.999);
        assertTrue(
                area > 0 && area < 0.5,
                "Площадь почти вырожденного треугольника должна быть между 0 и 0,5. Фактическая площадь: " + area
        );
    }

    @Test(
            dataProvider = "invalidSideData",
            description = "Невалидные стороны должны выбрасывать IllegalArgumentException"
    )
    public void invalidSideShouldThrowException(double a, double b, double c, String description) {
        try {
            TriangleAreaCalculator.calculateArea(a, b, c);
            fail("Ожидалось IllegalArgumentException: " + description);
        } catch (IllegalArgumentException e) {
            assertTrue(
                    e.getMessage().contains("All sides must be positive"),
                    "Сообщение должно содержать 'All sides must be positive'. Фактическое: " + e.getMessage()
            );
        }
    }

    @Test(
            dataProvider = "invalidTriangleData",
            description = "Невалидный треугольник должен выбрасывать IllegalArgumentException"
    )
    public void invalidTriangleShouldThrowException(double a, double b, double c, String description) {
        try {
            TriangleAreaCalculator.calculateArea(a, b, c);
            fail("Ожидалось IllegalArgumentException: " + description);
        } catch (IllegalArgumentException e) {
            assertTrue(
                    e.getMessage().contains("Triangle inequality violated"),
                    "Сообщение должно содержать 'Triangle inequality violated'. Фактическое: " + e.getMessage()
            );
        }
    }
}
