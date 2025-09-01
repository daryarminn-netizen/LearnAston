package Test;

import aston.darya.homework.Lesson_7_junit_5.NumberComparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComparatorTest {

    @Test
    void testCompareNumbers() {
        assertEquals(1, NumberComparator.compareNumbers(10, 5));
        assertEquals(-1, NumberComparator.compareNumbers(5, 10));
        assertEquals(0, NumberComparator.compareNumbers(7, 7));
    }
}
