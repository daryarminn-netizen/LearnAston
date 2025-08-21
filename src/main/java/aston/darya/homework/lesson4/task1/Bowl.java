package aston.darya.homework.lesson4.task1;

public class Bowl {
    private int foodCapacity;

    public Bowl(int foodCapacity) {
        if (foodCapacity > 0) {
            this.foodCapacity = foodCapacity;
        }
    }

    public void addFood(int food) {
        if (food < 0) {
            System.out.println("Вы пытаетесь добавить отрицательную еду");
            return;
        }
        System.out.printf("В миску добавлено %s еды\n", food);
        foodCapacity = foodCapacity + food;
    }

    public boolean getFood(int foodAmount) {
        if (foodAmount > foodCapacity) {
            System.out.printf("В миске осталось еды %s\n", foodCapacity);
            return false;
        }

        foodCapacity = foodCapacity - foodAmount;
        System.out.printf("Из миски взяли %s еды, осталось %s еды\n",
                foodAmount, foodCapacity);
        return true;
    }

    public int getFoodAmount() {
        return foodCapacity;
    }
}
