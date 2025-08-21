package aston.darya.homework.lesson4.task2;

public class Main {

    public static void main(String[] args) {
        Figure circle = new Circle(Color.RED, Color.BLACK, 12);
        Figure rectangle = new Rectangle(Color.BLUE, Color.GREEN, 5, 10);
        Figure triangle = new Triangle(Color.YELLOW, Color.PURPLE, 8, 10, 15);

        printFigureInfo(circle);
        printFigureInfo(rectangle);
        printFigureInfo(triangle);
    }

    public static void printFigureInfo(Figure figure) {
        System.out.println(figure.getFigureType() + ":");
        System.out.println("Цвет заливки: " + figure.getFillColor());
        System.out.println("Цвет границы: " + figure.getBorderColor());
        System.out.println("   ──────────────────────────");
        System.out.println("Периметр: " + String.format("%.2f", figure.getPerimeter()));
        System.out.println("Площадь: " + String.format("%.2f", figure.getArea()));
        System.out.println("──────────────────────────");
    }
}
