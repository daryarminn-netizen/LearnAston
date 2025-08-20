package aston.darya.homework.lesson3.task3;

import java.time.LocalTime;

public class Park {
    private String name;
    private Attraction[] attractions = new Attraction[10];

    public Park(String name) {
        this.name = name;
    }

    public void addAttraction(String name,
                              LocalTime openingTime,
                              LocalTime closingTime,
                              double price) {
        for (int i = 0; i < attractions.length; i++) {
            if (attractions[i] == null) {
                attractions[i] = new Attraction(name, openingTime, closingTime, price);
                break;
            }
        }
    }

    public static class Attraction {
        private String name;
        private LocalTime openingTime;
        private LocalTime closingTime;
        private double price;

        public Attraction(String name, LocalTime openingTime, LocalTime closingTime, double price) {
            this.name = name;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("Аттракцион: %s, Время работы: %s - %s, Стоимость: %.2f руб.",
                    name, openingTime, closingTime, price);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Парк: ").append(name).append("\n");
        sb.append("Аттракционы:\n");
        for (Attraction attraction : attractions) {
            if (attraction != null) {
                sb.append("  - ").append(attraction).append("\n");
            }
        }
        return sb.toString();
    }
}
