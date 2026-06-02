package lesson_2;

import java.time.LocalDate;

class Product {
    String productName;
    String productionDate;
    String manufacturer;
    String countryOfOrigin;
    int price;
    boolean bookingStatus;

    public Product(String productName, String productionDate, String manufacturer, String countryOfOrigin, int price, boolean bookingStatus) {
        this.productName = productName;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    public void printInfo() {
        System.out.println("Информация о продукте:");
        System.out.println("Название: " + productName);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price);
        System.out.println("Статус бронирования: " + (bookingStatus ? "Забронировано" : "Не забронировано"));
    }
}
