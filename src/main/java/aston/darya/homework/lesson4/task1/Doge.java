package aston.darya.homework.lesson4.task1;

public class Doge extends Animal {

    public static int countCreated;

    public Doge(String name) {
        super(name);
        maxRunDistance = 500;
        maxSwimDistance = 10;
        countCreated++;
    }

    @Override
    public void run(int distance) {
        if (distance < 0) {
            System.out.println("Дистанция бега не может быть отрицательным числом");
            return;
        }
        if (distance > 0 && distance <= maxRunDistance) {
            System.out.printf("Собака %s пробежала %s м.\n", name, distance);
        } else {
            System.out.printf("Собака %s может пробежать только %s м.\n", name, maxRunDistance);
        }
    }

    @Override
    public void swim(int distance) {
        if (distance < 0) {
            System.out.println("Дистанция плавания не может быть отрицательным числом");
            return;
        }
        if (distance > 0 && distance <= maxSwimDistance) {
            System.out.printf("Собака %s проплыла %s м.\n", name, distance);
        } else {
            System.out.printf("Собака %s может проплыть только %s м.\n", name, maxSwimDistance);
        }
    }

    public static int getCountCreated() {
        return countCreated;
    }
}
