package aston.darya.homework.lesson4.task2;

public interface TwoDimensionalShape {

    /**
     * Вычислить периметр фигуры
     */
    default double calculatePerimeter(double ... sides) {
        double sum = 0;
        for (double side : sides) {
            sum += side;
        }
        return sum;
    }

    /**
     * Вычислить площадь фигуры
     */
    double getArea();

    /**
     * Тип двумерной фигуры
     */
    String getFigureType();
}
