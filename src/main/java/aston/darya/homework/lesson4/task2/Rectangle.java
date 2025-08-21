package aston.darya.homework.lesson4.task2;

public class Rectangle extends Figure {

    private double height;
    private double width;

    public Rectangle(Color fillColor,
                     Color borderColor,
                     double height,
                     double width) {
        super(fillColor, borderColor);
        this.height = height;
        this.width = width;
    }

    public double getPerimeter() {
        return calculatePerimeter(width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String getFigureType() {
        return "Прямоугольник";
    }
}
