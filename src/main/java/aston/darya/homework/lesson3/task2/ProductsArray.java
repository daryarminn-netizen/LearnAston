package aston.darya.homework.lesson3.task2;

import java.time.OffsetDateTime;

public class ProductsArray {

        private String name;
        private OffsetDateTime productionDate;
        private String manufacturer;
        private String countryOfOrigin;
        private double price;
        private boolean isReserved;

        public ProductsArray(String name,
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
