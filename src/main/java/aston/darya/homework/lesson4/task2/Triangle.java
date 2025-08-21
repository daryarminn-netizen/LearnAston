package aston.darya.homework.lesson4.task2;

public class Triangle extends Figure {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(Color fillColor,
                    Color borderColor,
                    double sideA,
                    double sideB,
                    double sideC) {
        super(fillColor, borderColor);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getPerimeter() {
        return calculatePerimeter(sideA + sideB + sideC);
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public String getFigureType() {
        return "Треугольник";
    }
}
