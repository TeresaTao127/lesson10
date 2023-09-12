package lesson10Task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {

    private static List<PhoneBookEntry>entries=new ArrayList<>();

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
                    PhoneBookEntry entry =new PhoneBookEntry(firstName,lastName,phoneNumber,address);
                    entries.add(entry);
                }
            }
            try {
                List<PhoneBookEntry> foundPeople=phoneBook.findPeopleByName("Simon", "Stone");
                System.out.println("Entry found:\n " + foundPeople);
            } catch (NoSuchElementException e) {
                System.out.println("Entry not found.");
            }
        } else {
            System.out.println("File not found.");
        }
    }

    public List<PhoneBookEntry>findPeopleByName(String firstName, String lastName){
        return entries.stream()
                .filter(entry ->entry.getFullName().equalsIgnoreCase(firstName+" "+lastName))
                .collect(Collectors.toList());
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
