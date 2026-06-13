package lesson_4;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Test 1: Correct array ===\n");
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int sum = ArrayTransformation.sumArray(correctArray);
            System.out.println("Sum of all elements: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Test 2: Wrong size (3x4) ===\n");
        String[][] wrongSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        try {
            int sum = ArrayTransformation.sumArray(wrongSizeArray);
            System.out.println("Sum of all elements: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Test 3: Invalid data in cell ===\n");
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "abc", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int sum = ArrayTransformation.sumArray(invalidDataArray);
            System.out.println("Sum of all elements: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Test 4: ArrayIndexOutOfBoundsException ===\n");

        try {
            System.out.println("Trying to access element at [4][0]...");
            String value = correctArray[4][0];
            System.out.println("Value: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Cannot access row index 4 because array has only 4 rows");
        }
    }
}
