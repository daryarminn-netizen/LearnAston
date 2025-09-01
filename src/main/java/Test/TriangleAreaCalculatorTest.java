package Test;

import aston.darya.homework.Lesson_7_junit_5.TriangleAreaCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleAreaCalculatorTest {

    @Test
    void testCalculateTriangleArea() {
        double result = TriangleAreaCalculator.calculateArea(10, 5);
        assertEquals(25.0, result, 0.001, "Площадь треугольника должна быть 25");
    }

    @Test
    void testCalculateAreaHeron(){
        double result = TriangleAreaCalculator.calculateAreaHeron(3, 4, 5);
        assertEquals(6.0, result, 0.001, "Площадь треугольника 3-4-5 должна быть 6");
    }

    @Test
    void testCalculateTriangleArea_NegativeSide() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TriangleAreaCalculator.calculateArea(-5, 10);
                });
    }

    @Test
    void testCalculateAreaHeron_InvalidSides(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TriangleAreaCalculator.calculateAreaHeron(1, 2, 10);
        });
    }

    @Test
    void testCalculateAreaHeron_NegativeSides(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
          TriangleAreaCalculator.calculateAreaHeron(-3, -4, 5);
        });
    }
}
