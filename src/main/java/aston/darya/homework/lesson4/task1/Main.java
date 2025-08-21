package aston.darya.homework.lesson4.task1;

public class Main {

    public static void main(String[] args) {
        Animal dogBobik = new Doge("Bobik");
        dogBobik.run(300);
        dogBobik.swim(5);

        Animal catAlex = new Cat("Alex");
        catAlex.run(156);
        catAlex.swim(10);

        Cat catMurzik = new Cat("Murzik");
        catMurzik.run(50);
        catMurzik.swim(34);

        System.out.printf("Создано собак: %s\nСоздано котов: %s\n",
                Doge.getCountCreated(), Cat.getCountCreated());

        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Муся");
        cats[1] = new Cat("Жора");
        cats[2] = new Cat("Кот");
        cats[3] = new Cat("Рич");

        Bowl bowl = new Bowl(30);

        for (Cat cat : cats) {
            cat.eat(bowl, 15);
        }

        for (Cat cat : cats) {
            System.out.printf("Кот %s, сытость = %s\n", cat.getName(), cat.isFullness());
        }

        bowl.addFood(16);
        Cat jora = cats[1];
        jora.eat(bowl, 10);


        System.out.printf("Кот %s, сытость = %s\n", jora.getName(), jora.isFullness());
   }
}
