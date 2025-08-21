package aston.darya.homework.lesson4.task1;

public class Cat extends Animal {

    private static int countCreated;

    private boolean isFullness;

    public Cat(String name) {
        super(name);
        maxRunDistance = 200;
        countCreated++;
        isFullness = false;
    }

    public static int getCountCreated() {
        return countCreated;
    }

    @Override
    public void run(int distance) {
        if (distance < 0) {
            System.out.println("Дистанция не может быть отрицательным числом");
            return;
        }

        if (distance > 0 && distance <= maxRunDistance) {
            System.out.printf("Кот %s пробежал %s м.\n", name, distance);
        } else {
            System.out.printf("Кот %s может пробежать только %s м.\n", name, maxRunDistance);
        }
    }

    @Override
    public void swim(int distance) {
        System.out.printf("Кот %s не умеет плавать!\n", name);
    }

    public void eat(Bowl bowl, int foodAmount) {
        if (bowl.getFood(foodAmount)) {
            isFullness = true;
        }
    }

    public boolean isFullness() {
        return isFullness;
    }
}
