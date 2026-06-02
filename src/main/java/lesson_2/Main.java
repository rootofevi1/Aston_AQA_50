package lesson_2;

public class Main {
    public static void main(String[] args) {

        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);

        productsArray[1] = new Product("iPhone 16 Pro Max", "15.03.2025",
                "Apple Inc.", "USA", 12999, false);

        productsArray[2] = new Product("Xiaomi 14 Ultra", "20.01.2025",
                "Xiaomi Corporation", "China", 4999, true);

        productsArray[3] = new Product("Google Pixel 9 Pro", "10.04.2025",
                "Google LLC", "USA", 8999, false);

        productsArray[4] = new Product("OnePlus 13", "05.02.2025",
                "OnePlus Technology", "China", 6499, true);

        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i].printInfo();
            System.out.println("---");
        }

        Park park = new Park("Центральный парк г. Новосибирска", "ул. Мичурина, д. 8");
        park.printInfoPark();

        Park.Attraction ferrisWheel = park.new Attraction("Колесо обозрения", "10:00", "22:00", 300);
        Park.Attraction rollerCoaster = park.new Attraction("Американские горки", "11:00", "21:00", 500);
        Park.Attraction bumperCars = park.new Attraction("Автодром", "10:30", "20:30", 200);
        Park.Attraction ghostHouse = park.new Attraction("Дом страхов", "12:00", "22:00", 350);

        ferrisWheel.printInfoAttraction();
        rollerCoaster.printInfoAttraction();
        bumperCars.printInfoAttraction();
        ghostHouse.printInfoAttraction();
    }
}
