package lesson_2;

public class Park {

    private String parkName;
    private String address;

    public Park(String parkName, String address) {
        this.parkName = parkName;
        this.address = address;
    }

    public class Attraction {
        private String name;
        private String openingTime;
        private String closingTime;
        private int price;

        public Attraction(String name, String openingTime, String closingTime, int price) {
            this.name = name;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.price = price;
        }

        public void printInfoAttraction() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + openingTime + " - " + closingTime);
            System.out.println("Стоимость: " + price + " руб.");
            System.out.println("---");
        }
    }

    public void printInfoPark() {
        System.out.println("Парк: " + parkName);
        System.out.println("Адрес: " + address);
        System.out.println("---");
    }
}
