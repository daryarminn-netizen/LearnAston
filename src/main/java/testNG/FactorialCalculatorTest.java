package testNG;

import aston.darya.homework.Lesson_7_junit_5.FactorialCalculator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;


public class FactorialCalculatorTest {

    @Test
    void testFactorialOfZero() {

        assertEquals(FactorialCalculator.calculateFactorial(0), 1);
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(FactorialCalculator.calculateFactorial(1), 1);
    }

    @Test
    void testFactorialOfFive() {
        assertEquals(FactorialCalculator.calculateFactorial(5), 120);
    }

    @Test
    void testFactorialOfTen() {
        assertEquals(FactorialCalculator.calculateFactorial(10), 3628800);
    }

    @Test
    void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.calculateFactorial(-1));
    }
}
