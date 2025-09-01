package Test;

import aston.darya.homework.Lesson_7_junit_5.ArithmeticOperations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticOperationsTest {

    @Test
    void testArithmeticOperations() {
        assertEquals(15, ArithmeticOperations.sum(10, 5));
        assertEquals(5, ArithmeticOperations.subtract(10, 5));
        assertEquals(50, ArithmeticOperations.multiply(10, 5));
        assertEquals(2, ArithmeticOperations.divide(10, 5));
        assertEquals(2.2, ArithmeticOperations.divide(11, 5));
    }

    @Test
    void DivisionByZero() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(10, 0));
    }
}

