package Lesson_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Вызов метода 1:");
        printThreeWords();

        System.out.println("Вызов метода 2:");
        checkSumSign();

        System.out.println("Вызов метода 3:");
        printColor();

        System.out.println("Вызов метода 4:");
        compareNumbers();

        System.out.println("Вызов метода 5:");
        boolean result = isSumBetweenTenAndTwenty(5, 20);
        System.out.println(result);

        System.out.println("Вызов метода 6:");
        isNumberPositiveOrNegativeConsole(5);

        System.out.println("Вызов метода 7:");
        boolean result2 = isNumberPositiveOrNegativeBoolean(0);
        System.out.println(result2);

        System.out.println("Вызов метода 8:");
        printString("TestString", 3);

        System.out.println("Вызов метода 9:");
        boolean result3 = isLeapYear(100);
        System.out.println(result3);

        System.out.println("Вызов метода 10:");
        int[] arrayReplaceOneAndZero = createAndReplaceArray();
        for(int i : arrayReplaceOneAndZero) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Вызов метода 11:");
        int[] arrayFillOutOneHundred = createHundredArray();
        for(int i : arrayFillOutOneHundred) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Вызов метода 12:");
        int[] arrayReplaceNumbersLessThanSix = createAndDoubleArray();
        for(int i : arrayReplaceNumbersLessThanSix) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Вызов метода 13:");
        int[][] matrix = createDiagonalMatrix();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Вызов метода 14:");
        int[] result4 = createRandomArray(10, 555);
        for(int i : result4) {
            System.out.print(i + " ");
        }
    }

    // Метод 1
    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // Метод 2
    static void checkSumSign() {
        int a = 15;
        int b = -30;
        int c = a + b;

        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // Метод 3
    static void printColor() {
        int value = 100;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // Метод 4
    static void compareNumbers() {
        int a = 1;
        int b = 2;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // Метод 5
    static boolean isSumBetweenTenAndTwenty(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // Метод 6
    static void isNumberPositiveOrNegativeConsole(int a) {
        if (a >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    // Метод 7
    static boolean isNumberPositiveOrNegativeBoolean(int a) {
        return a < 0;
    }

    // Метод 8
    static void printString(String s, int a) {
        while (a > 0) {
            System.out.println(s);
            a--;
        }
    }

    // Метод 9
    static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    // Метод 10
    static int[] createAndReplaceArray() {
        int[] array = new int[] { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else if (array[i] == 0) {
                array[i] = 1;
            }
        }
        return array;
    }

    // Метод 11
    static int[] createHundredArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    // Метод 12
    static int[] createAndDoubleArray() {
        int[] array = new int[] { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        return array;
    }

    // Метод 13
    static int[][] createDiagonalMatrix() {
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == j || i + j == 2) {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }

    // Метод 14
    static int[] createRandomArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }
}