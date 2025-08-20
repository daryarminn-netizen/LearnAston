package aston.darya.homework.lesson3.task2;

import aston.darya.homework.lesson3.task1.Product;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product(
                "Sumsung S20",
                OffsetDateTime.of(2020, 4, 30, 17,54,0, 4323454, ZoneOffset.UTC),
                "Sumsung Corp.",
                "Korea",
                4383,
                true
        );
        productsArray[1] = new Product(
                "iPhone",
                OffsetDateTime.of(2025, 8,12, 0, 0, 0, 0,ZoneOffset.UTC),
                "Apple",
                "USA",
                1500,
                false
        );
        productsArray[2] = new Product(
                "Honor",
                OffsetDateTime.of(2018, 4, 23, 17, 0, 0, 0,ZoneOffset.UTC),
                "Honor Corp.",
                "China",
                876,
                false
        );
        productsArray[3] = new Product(
                "iPhone17",
                OffsetDateTime.of(2018, 8, 10, 14, 0, 0, 0,ZoneOffset.UTC),
                "Apple",
                "USA",
                2000,
                true
        );
        productsArray[4] = new Product(
                "Huawei",
                OffsetDateTime.of(2023, 9, 17, 9, 30, 0, 0,ZoneOffset.UTC),
                "Huawei Corp.",
                "China",
                945,
                true
        );
        for (Product product : productsArray) {
            System.out.println(product);
        }
    }
}
