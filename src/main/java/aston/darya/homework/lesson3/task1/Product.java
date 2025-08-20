package aston.darya.homework.lesson3.task1;

import java.time.OffsetDateTime;

/**
 * 1. Создать класс "Товар" с полями: название, дата производства, производитель,
 * страна происхождения, цена, состояние бронирования покупателем.
 * Конструктор класса должен заполнять эти поля при создании объекта.
 * Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль.
 */
public class Product {

    private String name;
    private OffsetDateTime productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean isReserved;

    public Product(String name,
                   OffsetDateTime productionDate,
                   String manufacturer,
                   String countryOfOrigin,
                   double price,
                   boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void printProductInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ",\n productionDate=" + productionDate +
                ",\n manufacturer='" + manufacturer + '\'' +
                ",\n countryOfOrigin='" + countryOfOrigin + '\'' +
                ",\n price=" + price +
                ",\n isReserved=" + isReserved +
                '}';
    }
}
