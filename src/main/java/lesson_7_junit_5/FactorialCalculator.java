package lesson_7_junit_5;

public class FactorialCalculator {

    public static long factorial(int n) {
        // Проверка на отрицательное число
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers: " + n);
        }

        // Факториал 0! = 1
        if (n == 0 || n == 1) {
            return 1L;
        }

        long result = 1L;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
