package aston.darya.homework.lesson4.task2;

public abstract class Figure implements TwoDimensionalShape {

    /**
     * Цвет заливки
     */
    private Color fillColor;

    /**
     * Цвет границ
     */
    private Color borderColor;

    public Figure(Color fillColor, Color borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public abstract double getPerimeter();

    public Color getFillColor() {
        return fillColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }
}
