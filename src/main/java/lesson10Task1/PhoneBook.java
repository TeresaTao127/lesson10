package lesson10Task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class PhoneBook {

    private Map<String, PhoneBookEntry> entries;

    public PhoneBook() {
        entries = new HashMap<>();
    }

    public void addEntry(String firstName, String lastName, String phoneNumber, String address) {
        if (firstName.isEmpty() || lastName.isEmpty() || address.isEmpty()) {
            throw new IllegalArgumentException("the address, first name, and last name fields are mandatory");
        }


        PhoneBookEntry entry = new PhoneBookEntry(firstName, lastName, phoneNumber, address);
        String key = firstName.toLowerCase() + " " + lastName.toLowerCase();
        entries.put(key, entry);

    }

    public PhoneBookEntry searchEntry(String firstName, String lastName) {
        String key = firstName.toLowerCase() + " " + lastName.toLowerCase();
        if (entries.containsKey(key)) {
            return entries.get(key);
        } else {
            throw new NoSuchElementException("Entry not found in the phone book.");
        }

    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        String filePath = "src\\main\\resources\\textFile.txt";
        Optional<String> fileContentOpt = readTextContentOpt(filePath);

        if (fileContentOpt.isPresent()) {
            String fileContent = fileContentOpt.get();
            String[] lines = fileContent.split("\n");
            for (String line : lines) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String firstName=data[0].trim();
                    String lastName=data[1].trim();
                    String phoneNumber=data[2].trim();
                    String address=data[3].trim();
                    phoneBook.addEntry(firstName, lastName, phoneNumber, address);
                }
            }
            try {
                PhoneBookEntry entry = phoneBook.searchEntry("Simon", "Stone");
                System.out.println("Entry found:\n " + entry);
            } catch (NoSuchElementException e) {
                System.out.println("Entry not found.");
            }
        } else {
            System.out.println("File not found.");
        }
    }

    private static Optional<String> readTextContentOpt(String filePath) {
        try {
            String textContent = Files.readString(Path.of(filePath));
            return Optional.of(textContent);
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
