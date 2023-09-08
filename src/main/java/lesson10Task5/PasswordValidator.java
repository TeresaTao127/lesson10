package lesson10Task5;


import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        String[] passwords = {
                "MyP@ssw1",
                "javaFirstpro1",
                "JAVAstudyIn2023",
                "Pass1",
                "23Password"
        };


        for (String password : passwords) {
            boolean isPasswordValid = validatePassword(password);
            if (isPasswordValid) {
                System.out.println("Password '" + password + "' is valid");
            } else {
                System.out.println("Password '" + password + "' is not valid");
            }
        }
    }

    private static boolean validatePassword(String password) {

        String uppercasePattern = ".*[A-Z].*";

        String digitPattern = ".*\\d.*";

        String lengthPattern = ".{7,}";

        String yearPattern = ".*(2023|23).*";

        String passwordRegex = "^(?=.*" + uppercasePattern + ")(?=.*" + digitPattern + ")" +
                "(?=" + lengthPattern + ")(?!" + yearPattern + ").*$";

        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
