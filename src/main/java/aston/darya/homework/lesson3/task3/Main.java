package aston.darya.homework.lesson3.task3;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        Park kyrlai = new Park("Кырлай");
        kyrlai.addAttraction("Колесо обозрения",
                LocalTime.of(10, 0),
                LocalTime.of(22, 0),
                1000);
        kyrlai.addAttraction("Американские горки",
                LocalTime.of(12, 0),
                LocalTime.of(22, 0),
                1500);

        System.out.println(kyrlai);
    }
}
