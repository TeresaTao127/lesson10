package lesson10Task5;


import java.util.regex.*;

public class PasswordValidator {
  public static void main(String[] args) {
    String password;
    boolean isPasswordValid = validatePassword(password = "MyP@ssw1");
    if (isPasswordValid) {
      System.out.println("Password '" + password + "' is valid");
    } else {
      System.out.println("Password '" + password + "' is not valid");
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

  public static boolean isPasswordValid(String password) {
    return validatePassword(password);
  }
}
