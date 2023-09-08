package lesson10Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumbersUtils {
    public static void main(String[] args) {
        String text = "342\n" +
                "5.34\n" +
                "756\n" +
                "1.234e+07\n" +
                "7.234243E-02\n" +
                "6.09\n" +
                "3457\n" +
                "87\n" +
                "1.0001\n" +
                "3\n" +
                "5";

        String integerPattern = "\\b[1-9](\\d+\\d)\\b";

        String floatPattern = "\\b\\d+\\.\\d+\\b";
        String scientificPattern = "\\b\\d+(\\.\\d+)?[eE][+-]?\\d+\\b";

        Pattern integerRegex = Pattern.compile(integerPattern);
        Pattern floatRegex = Pattern.compile(floatPattern);
        Pattern scientificRegex = Pattern.compile(scientificPattern);

        Matcher integerMatcher = integerRegex.matcher(text);
        Matcher floatMatcher = floatRegex.matcher(text);
        Matcher scientificMatcher = scientificRegex.matcher(text);

        List<String> integers = new ArrayList<>();
        List<String> floats = new ArrayList<>();
        List<String> scienficNumbers = new ArrayList<>();


        while (floatMatcher.find()) {
            floats.add(floatMatcher.group());
        }
        while (scientificMatcher.find()) {
            scienficNumbers.add(scientificMatcher.group());
        }
        while (integerMatcher.find()) {
            integers.add(integerMatcher.group());

        }

        System.out.println("Integers: " + integers);
        System.out.println("Floating numbers: " + floats);
        System.out.println("Scientific Notation numbers: " + scienficNumbers);

    }

}

