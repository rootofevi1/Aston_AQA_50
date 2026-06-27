package lesson_7_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticCalculatorTest {

    // ТЕСТЫ ДЛЯ СЛОЖЕНИЯ
    @Test
    @DisplayName("Сложение положительных чисел")
    void addPositiveNumbers() {
        assertEquals(5, ArithmeticCalculator.add(2, 3), "2 + 3 = 5");
        assertEquals(10, ArithmeticCalculator.add(4, 6), "4 + 6 = 10");
    }

    @Test
    @DisplayName("Сложение с отрицательными числами")
    void addNegativeNumbers() {
        assertEquals(-5, ArithmeticCalculator.add(-2, -3), "-2 + (-3) = -5");
        assertEquals(-1, ArithmeticCalculator.add(2, -3), "2 + (-3) = -1");
        assertEquals(1, ArithmeticCalculator.add(-2, 3), "-2 + 3 = 1");
    }

    @Test
    @DisplayName("Сложение с нулем")
    void addZero() {
        assertEquals(5, ArithmeticCalculator.add(5, 0), "5 + 0 = 5");
        assertEquals(-3, ArithmeticCalculator.add(0, -3), "0 + (-3) = -3");
        assertEquals(0, ArithmeticCalculator.add(0, 0), "0 + 0 = 0");
    }

    // ТЕСТЫ ДЛЯ ВЫЧИТАНИЯ
    @Test
    @DisplayName("Вычитание чисел")
    void subtractNumbers() {
        assertEquals(3, ArithmeticCalculator.subtract(5, 2), "5 - 2 = 3");
        assertEquals(-1, ArithmeticCalculator.subtract(2, 3), "2 - 3 = -1");
        assertEquals(5, ArithmeticCalculator.subtract(-2, -7), "-2 - (-7) = 5");
    }

    // ТЕСТЫ ДЛЯ УМНОЖЕНИЯ
    @Test
    @DisplayName("Умножение чисел")
    void multiplyNumbers() {
        assertEquals(6, ArithmeticCalculator.multiply(2, 3), "2 * 3 = 6");
        assertEquals(-6, ArithmeticCalculator.multiply(-2, 3), "-2 * 3 = -6");
        assertEquals(0, ArithmeticCalculator.multiply(0, 5), "0 * 5 = 0");
    }

    // ТЕСТЫ ДЛЯ ДЕЛЕНИЯ
    @Test
    @DisplayName("Целочисленное деление")
    void divideNumbers() {
        assertEquals(2, ArithmeticCalculator.divide(6, 3), "6 / 3 = 2");
        assertEquals(2, ArithmeticCalculator.divide(7, 3), "7 / 3 = 2 (целочисленное)");
        assertEquals(-2, ArithmeticCalculator.divide(-6, 3), "-6 / 3 = -2");
    }

    @Test
    @DisplayName("Деление на ноль должно выбросить исключение")
    void divideByZeroShouldThrowException() {
        assertThrows(ArithmeticException.class,
                () -> ArithmeticCalculator.divide(5, 0),
                "Деление на ноль должно вызывать ArithmeticException");
    }
}
