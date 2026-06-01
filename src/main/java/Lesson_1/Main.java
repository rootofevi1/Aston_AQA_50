package Lesson_1;

import static Lesson_1.Methods.*;

public class Main {
    public static void main(String[] args) {

        printThreeWords();

        checkSumSign();

        printColor();

        compareNumbers();

        boolean result = isSumBetweenTenAndTwenty(5, 20);
        System.out.println(result);

        isNumberPositiveOrNegativeConsole(5);

        boolean result2 = isNumberPositiveOrNegativeBoolean(0);
        System.out.println(result2);

        printString("TestString", 3);

        boolean result3 = isLeapYear(100);
        System.out.println(result3);

        int[] arrayReplaceOneAndZero = new int[] { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < arrayReplaceOneAndZero.length; i++) {
            if (arrayReplaceOneAndZero[i] == 1) {
                arrayReplaceOneAndZero[i] = 0;
            } else if (arrayReplaceOneAndZero[i] == 0) {
                arrayReplaceOneAndZero[i] = 1;
            }
        }
        for(int i : arrayReplaceOneAndZero) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[] arrayFillOutOneHundred = new int[100];
        for (int i = 0; i < arrayFillOutOneHundred.length; i++) {
            arrayFillOutOneHundred[i] = i + 1;
        }
        for(int i : arrayFillOutOneHundred) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[] arrayReplaceNumbersLessThanSix = new int[] { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arrayReplaceNumbersLessThanSix.length; i++) {
            if (arrayReplaceNumbersLessThanSix[i] < 6) {
                arrayReplaceNumbersLessThanSix[i] *= 2;
            }
        }
        for(int i : arrayReplaceNumbersLessThanSix) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == j || i + j == 2) {
                    matrix[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int[] result4 = createRandomArray(10, 555);
        for(int i : result4) {
            System.out.print(i + " ");
        }
    }
}
