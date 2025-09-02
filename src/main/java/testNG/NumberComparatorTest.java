package testNG;

import aston.darya.homework.Lesson_7_junit_5.NumberComparator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumberComparatorTest {

    @Test
    void testCompareNumbers() {
        assertEquals(NumberComparator.compareNumbers(10, 5), 1);
        assertEquals(NumberComparator.compareNumbers(5, 10), -1);
        assertEquals(NumberComparator.compareNumbers(7, 7), 0);
    }
}
