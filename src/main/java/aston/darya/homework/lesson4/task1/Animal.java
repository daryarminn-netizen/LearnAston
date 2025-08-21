package aston.darya.homework.lesson4.task1;

public abstract class Animal {

    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}
