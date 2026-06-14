package lesson_5_phone_book;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Ivanov", "+123456789");
        phoneBook.add("Popov", "+987654321");
        phoneBook.add("Ivanov", "+555555555");
        phoneBook.add("Ivanov", "+444444444");
        phoneBook.add("Smirnoff", "+111111111");
        phoneBook.add("Popov", "+999999999");

        System.out.println("=== Phone Book ===");

        searchAndPrint(phoneBook, "Ivanov");
        searchAndPrint(phoneBook, "Popov");
        searchAndPrint(phoneBook, "Smirnoff");
        searchAndPrint(phoneBook, "Kozlov");
    }

    public static void searchAndPrint(PhoneBook phoneBook, String lastName) {
        System.out.println("\nSearching for '" + lastName + "':");
        List<String> phones = phoneBook.get(lastName);
        if (phones.isEmpty()) {
            System.out.println("No numbers found");
        } else {
            for (String phone : phones) {
                System.out.println(phone);
            }
        }
    }
}
