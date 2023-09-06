package lesson10Task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalIdValidator {
    public static void main(String[] args) {
        String PersonalIdCandidate="11002200441";
        boolean isPersonalId = validatePersonalId(PersonalIdCandidate);
        if (isPersonalId) {
            System.out.println(  "Personal ID: " + PersonalIdCandidate+ " is valid");
        } else {
            System.out.println( "Personal ID: " + PersonalIdCandidate+ " is not valid");
        }
    }

    public static boolean validatePersonalId(String PersonalIdCandidate) {
        Pattern pattern = Pattern.compile("\\d{11}");
        Matcher matcher = pattern.matcher(PersonalIdCandidate);
        return matcher.matches();
    }
}