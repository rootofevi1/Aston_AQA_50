package lesson_7_testng;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @Test
    @DisplayName("Сравнение: a > b")
    void compareGreater() {
        assertEquals(1, NumberComparator.compare(5, 3), "5 > 3");
        assertEquals(1, NumberComparator.compare(0, -1), "0 > -1");
        assertEquals(1, NumberComparator.compare(Integer.MAX_VALUE, 0), "MAX > 0");
    }

    @Test
    @DisplayName("Сравнение: a < b")
    void compareLess() {
        assertEquals(-1, NumberComparator.compare(3, 5), "3 < 5");
        assertEquals(-1, NumberComparator.compare(-1, 0), "-1 < 0");
        assertEquals(-1, NumberComparator.compare(0, Integer.MAX_VALUE), "0 < MAX");
    }

    @Test
    @DisplayName("Сравнение: a == b")
    void compareEqual() {
        assertEquals(0, NumberComparator.compare(5, 5), "5 == 5");
        assertEquals(0, NumberComparator.compare(0, 0), "0 == 0");
        assertEquals(0, NumberComparator.compare(-5, -5), "-5 == -5");
    }

    @Test
    @DisplayName("Сравнение с граничными значениями")
    void compareEdgeCases() {
        assertEquals(1, NumberComparator.compare(Integer.MAX_VALUE, Integer.MIN_VALUE),
                "MAX > MIN");
        assertEquals(-1, NumberComparator.compare(Integer.MIN_VALUE, Integer.MAX_VALUE),
                "MIN < MAX");
        assertEquals(0, NumberComparator.compare(Integer.MAX_VALUE, Integer.MAX_VALUE),
                "MAX == MAX");
    }
}
