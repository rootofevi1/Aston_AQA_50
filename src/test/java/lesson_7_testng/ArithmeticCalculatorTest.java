package lesson_7_testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ArithmeticCalculatorTest {

    // ТЕСТЫ ДЛЯ СЛОЖЕНИЯ
    @Test(description = "Сложение положительных чисел")
    public void addPositiveNumbers() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(
                ArithmeticCalculator.add(2, 3),
                5,
                "2 + 3 = 5"
        );

        softAssert.assertEquals(
                ArithmeticCalculator.add(4, 6),
                10,
                "4 + 6 = 10"
        );

        softAssert.assertAll();
    }

    @Test(description = "Сложение с отрицательными числами")
    public void addNegativeNumbers() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(
                ArithmeticCalculator.add(-2, -3),
                -5,
                "-2 + (-3) = -5"
        );

        softAssert.assertEquals(
                ArithmeticCalculator.add(2, -3),
                -1,
                "2 + (-3) = -1"
        );

        softAssert.assertEquals(
                ArithmeticCalculator.add(-2, 3),
                1,
                "-2 + 3 = 1"
        );

        softAssert.assertAll();
    }

    @Test(description = "Сложение с нулем")
    public void addZero() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(
                ArithmeticCalculator.add(5, 0),
                5,
                "5 + 0 = 5"
        );

        softAssert.assertEquals(
                ArithmeticCalculator.add(0, -3),
                -3,
                "0 + (-3) = -3"
        );

        softAssert.assertEquals(
                ArithmeticCalculator.add(0, 0),
                0,
                "0 + 0 = 0"
        );

        softAssert.assertAll();
    }

    // ТЕСТЫ ДЛЯ ВЫЧИТАНИЯ
    @Test(description = "Вычитание чисел")
    public void subtractNumbers() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(
                ArithmeticCalculator.subtract(5, 2),
                3,
                "5 - 2 = 3"
        );

        softAssert.assertEquals(
                ArithmeticCalculator.subtract(2, 3),
                -1,
                "2 - 3 = -1"
        );

        softAssert.assertEquals(
                ArithmeticCalculator.subtract(-2, -7),
                5,
                "-2 - (-7) = 5"
        );

        softAssert.assertAll();
    }

    // ТЕСТЫ ДЛЯ УМНОЖЕНИЯ
    @Test(description = "Умножение чисел")
    public void multiplyNumbers() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(
                ArithmeticCalculator.multiply(2, 3),
                6,
                "2 * 3 = 6"
        );

        softAssert.assertEquals(
                ArithmeticCalculator.multiply(-2, 3),
                -6,
                "-2 * 3 = -6"
        );

        softAssert.assertEquals(
                ArithmeticCalculator.multiply(0, 5),
                0,
                "0 * 5 = 0"
        );

        softAssert.assertAll();
    }

    // ТЕСТЫ ДЛЯ ДЕЛЕНИЯ
    @Test(description = "Целочисленное деление")
    public void divideNumbers() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(
                ArithmeticCalculator.divide(6, 3),
                2,
                "6 / 3 = 2"
        );

        softAssert.assertEquals(
                ArithmeticCalculator.divide(7, 3),
                2,
                "7 / 3 = 2 (целочисленное)"
        );

        softAssert.assertEquals(
                ArithmeticCalculator.divide(-6, 3),
                -2,
                "-6 / 3 = -2"
        );

        softAssert.assertAll();
    }

    @Test(
            description = "Деление на ноль должно выбросить исключение",
            expectedExceptions = ArithmeticException.class,
            expectedExceptionsMessageRegExp = "Division by zero is not allowed"
    )
    public void divideByZeroShouldThrowException() {
        ArithmeticCalculator.divide(5, 0);
    }
}
