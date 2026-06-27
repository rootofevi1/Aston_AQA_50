package lesson_7_testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumberComparatorTest {

    @DataProvider(name = "comparisonData")
    public Object[][] comparisonData() {
        return new Object[][]{
                // a > b
                {5, 3, 1, "5 > 3"},
                {0, -1, 1, "0 > -1"},
                {Integer.MAX_VALUE, 0, 1, "MAX_VALUE > 0"},

                // a < b
                {3, 5, -1, "3 < 5"},
                {-1, 0, -1, "-1 < 0"},
                {0, Integer.MAX_VALUE, -1, "0 < MAX_VALUE"},

                // a == b
                {5, 5, 0, "5 == 5"},
                {0, 0, 0, "0 == 0"},
                {-5, -5, 0, "-5 == -5"},

                // Граничные значения
                {Integer.MAX_VALUE, Integer.MIN_VALUE, 1, "MAX_VALUE > MIN_VALUE"},
                {Integer.MIN_VALUE, Integer.MAX_VALUE, -1, "MIN_VALUE < MAX_VALUE"},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, "MAX_VALUE == MAX_VALUE"}
        };
    }

    @Test(
            dataProvider = "comparisonData",
            description = "Сравнение двух целых чисел"
    )
    public void compareNumbers(int a, int b, int expected, String message) {
        assertEquals(
                NumberComparator.compare(a, b),
                expected,
                message
        );
    }
}
