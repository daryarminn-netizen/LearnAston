package aston.darya.homework.lesson4.task2;

import java.util.StringJoiner;

public class Circle extends Figure {

    private double radius;

    public Circle(Color fillColor,
                  Color borderColor,
                  double radius) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    /**
     * Возвращает вычисленный периметр, либо -1 если
     * передано неправильное количество измерений для круга
     */
    @Override
    public double calculatePerimeter(double... sides) {
        if (sides.length != 1) {
            System.out.println("Передано неправильное количество измерений для круга");
            return -1;
        }
        return 2 * Math.PI * sides[0];
    }

    public double getPerimeter() {
        return calculatePerimeter(radius);
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Circle.class.getSimpleName() + "[", "]")
                .add("radius=" + radius)
                .add("fillColor=" + getFillColor())
                .add("borderColor=" + getBorderColor())
                .toString();
    }

    @Override
    public String getFigureType() {
        return "Круг";
    }
}
