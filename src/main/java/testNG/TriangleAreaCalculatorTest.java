package testNG;

import aston.darya.homework.Lesson_7_testng.TriangleAreaCalculator;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class TriangleAreaCalculatorTest {

    @Test
    void testCalculateTriangleArea() {
        double result = TriangleAreaCalculator.calculateArea(10, 5);
        assertEquals(result, 25.0, 0.001, "Площадь треугольника должна быть 25");
    }

    @Test
    void testCalculateAreaHeron(){
        double result = TriangleAreaCalculator.calculateAreaHeron(3, 4, 5);
        assertEquals(result, 6.0, 0.001, "Площадь треугольника 3-4-5 должна быть 6");
    }

    @Test
    void testCalculateTriangleArea_NegativeSide() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleAreaCalculator.calculateArea(-5, 10);
                });
    }

    @Test
    void testCalculateAreaHeron_InvalidSides(){
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleAreaCalculator.calculateAreaHeron(1, 2, 10);
        });
    }

    @Test
    void testCalculateAreaHeron_NegativeSides(){
        assertThrows(IllegalArgumentException.class, () -> {
          TriangleAreaCalculator.calculateAreaHeron(-3, -4, 5);
        });
    }
}
