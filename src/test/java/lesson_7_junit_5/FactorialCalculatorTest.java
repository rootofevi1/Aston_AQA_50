package lesson_7_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    @DisplayName("factorial(0) = 1 (минимальное допустимое значение)")
    void factorialOfZeroShouldReturnOne() {
        assertEquals(1L, FactorialCalculator.factorial(0), "0! = 1");
    }

    @Test
    @DisplayName("factorial(1) = 1 (первое значение с циклом)")
    void factorialOfOneShouldReturnOne() {
        assertEquals(1L, FactorialCalculator.factorial(1), "1! = 1");
    }

    @Test
    @DisplayName("factorial(20) - последнее значение, помещающееся в long")
    void factorialOfTwentyShouldReturnCorrectValue() {
        assertEquals(2432902008176640000L, FactorialCalculator.factorial(20),
                "20! должен быть равен 2432902008176640000");
    }

    @Test
    @DisplayName("factorial(21) - переполнение long (выход за границу)")
    void factorialOfTwentyOneShouldOverflow() {
        long result = FactorialCalculator.factorial(21);
        assertTrue(result < 0,
                "21! должен вызвать переполнение long (результат отрицательный)");
    }

    @Test
    @DisplayName("factorial(5) = 120 (типичное значение из середины класса эквивалентности)")
    void factorialOfFiveShouldReturnOneHundredTwenty() {
        assertEquals(120L, FactorialCalculator.factorial(5), "5! = 120");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5})
    @DisplayName("Любое отрицательное число должно выбрасывать IllegalArgumentException")
    void factorialOfAnyNegativeNumberShouldThrowException(int n) {
        assertThrows(IllegalArgumentException.class,
                () -> FactorialCalculator.factorial(n),
                "Отрицательное число " + n + " должно вызывать IllegalArgumentException");
    }
}
