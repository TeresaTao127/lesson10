package lesson10Task6;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BirthDateValidator {
    public static void main(String[] args) {
        String[] birthDates = {
                "1997-08-03",
                "2024-07-27",
                "2021-08"
        };

        for (String birthDateString : birthDates) {
            boolean isBirthDate = validateBirthDate(birthDateString);

            if (isBirthDate) {
                LocalDate birthDate = LocalDate.parse(birthDateString);
                LocalDate currentDate = LocalDate.now();
                int age = currentDate.getYear() - birthDate.getYear();
                if (age>0) {
                    String dayOfWeek = birthDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
                    int weekOfYear = birthDate.get(WeekFields.ISO.weekOfWeekBasedYear());
                    System.out.println("BirthDate " + birthDateString + " is valid");
                    System.out.println("Age " + age + " years");
                    System.out.println("Day of the week of birth " + dayOfWeek);
                    System.out.println("Week of the year of birth " + weekOfYear);
                    System.out.println("----------------------------------------");
                }else {
                    System.out.println("BirthDate " + birthDateString + " is not valid");
                    System.out.println("----------------------------------------");
                }
            } else {
                System.out.println("BirthDate " + birthDateString + " is not valid");
                System.out.println("----------------------------------------");
            }
        }
    }

    private static boolean validateBirthDate(String birthDate) {
        String birthDateRegex = "\\d{4}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(birthDateRegex);
        Matcher matcher = pattern.matcher(birthDate);
        return matcher.matches();
    }
}
   

