package testNG;

import aston.darya.homework.Lesson_7_junit_5.ArithmeticOperations;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class ArithmeticOperationsTest {

    @Test
    void testArithmeticOperations() {
        assertEquals(ArithmeticOperations.sum(10, 5), 15);
        assertEquals(ArithmeticOperations.subtract(10, 5), 5);
        assertEquals(ArithmeticOperations.multiply(10, 5), 50);
        assertEquals(ArithmeticOperations.divide(10, 5), 2);
        assertEquals(ArithmeticOperations.divide(11, 5), 2.2);
    }

    @Test
    void DivisionByZero() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(10, 0));
    }
}

