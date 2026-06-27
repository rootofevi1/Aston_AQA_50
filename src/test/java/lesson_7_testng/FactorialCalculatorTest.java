package lesson_7_testng;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialCalculatorTest {

    // ПОЗИТИВНЫЕ ТЕСТЫ
    @Test(description = "factorial(0) = 1 (минимальное допустимое значение)")
    public void factorialOfZeroShouldReturnOne() {
        assertEquals(
                FactorialCalculator.factorial(0),
                1L,
                "0! = 1"
        );
    }

    @Test(description = "factorial(1) = 1 (первое значение с циклом)")
    public void factorialOfOneShouldReturnOne() {
        assertEquals(
                FactorialCalculator.factorial(1),
                1L,
                "1! = 1"
        );
    }

    @Test(description = "factorial(5) = 120 (типичное значение из середины класса эквивалентности)")
    public void factorialOfFiveShouldReturnOneHundredTwenty() {
        assertEquals(
                FactorialCalculator.factorial(5),
                120L,
                "5! = 120"
        );
    }

    @Test(description = "factorial(20) - последнее значение, помещающееся в long")
    public void factorialOfTwentyShouldReturnCorrectValue() {
        assertEquals(
                FactorialCalculator.factorial(20),
                2432902008176640000L,
                "20! должен быть равен 2432902008176640000"
        );
    }

    @Test(description = "factorial(21) - переполнение long (выход за границу)")
    public void factorialOfTwentyOneShouldOverflow() {
        long result = FactorialCalculator.factorial(21);
        assertTrue(
                result < 0,
                "21! должен вызвать переполнение long (результат отрицательный). " +
                        "Фактический результат: " + result
        );
    }

    // НЕГАТИВНЫЙ ТЕСТ (Отрицательное число)
    @Test(
            description = "Отрицательное число должно выбрасывать IllegalArgumentException",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Factorial is not defined for negative numbers: .*"
    )
    public void factorialOfNegativeNumberShouldThrowException() {
        FactorialCalculator.factorial(-1);
    }
}
