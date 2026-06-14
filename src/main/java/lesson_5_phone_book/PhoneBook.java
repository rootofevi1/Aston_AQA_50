package lesson_5_phone_book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private final Map<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        contacts.putIfAbsent(lastName, new ArrayList<>());
        contacts.get(lastName).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return contacts.getOrDefault(lastName, new ArrayList<>());
    }
}
