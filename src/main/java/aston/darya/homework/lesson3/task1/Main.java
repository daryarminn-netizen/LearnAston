package aston.darya.homework.lesson3.task1;

import java.time.OffsetDateTime;

public class Main {

    public static void main(String[] args) {
        Product product = new Product("Iphone",
                OffsetDateTime.now(),
                "APPLE",
                "USA",
                1300.12,
                true);
        product.printProductInfo();
    }
    }
