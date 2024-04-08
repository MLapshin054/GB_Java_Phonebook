import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Mary", "+7383123");
        addContact(phoneBook, "Alex", "+7383321");
        addContact(phoneBook, "Lucy", "+7383456");
        addContact(phoneBook, "Mary", "+7383777");
        addContact(phoneBook, "Gans", "+7383654");
        addContact(phoneBook, "Lilu", "+7383000");
        addContact(phoneBook, "Sara", "+7383001");

        printMain(phoneBook);
    }

    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    private static void printMain(Map<String, List<String>> phoneBook) {

        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        entries.sort(Comparator.comparingInt(entry -> entry.getValue().size()));

        for (int i = entries.size() - 1; i >= 0; i--) {
            Map.Entry<String, List<String>> entry = entries.get(i);
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();

            System.out.println(name + ": " + phoneNumbers);
        }
    }
}