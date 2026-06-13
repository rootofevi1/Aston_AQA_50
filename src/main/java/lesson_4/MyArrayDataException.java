package lesson_4;

public class MyArrayDataException extends Exception {
    final int row;
    final int col;
    final String invalidValue;

    public MyArrayDataException(int row, int col, String invalidValue) {
        super(String.format("Invalid data at cell [%d][%d]: '%s' cannot be converted to int", row, col, invalidValue));
        this.row = row;
        this.col = col;
        this.invalidValue = invalidValue;
    }
}
