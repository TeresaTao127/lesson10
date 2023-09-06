package lesson10Task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLValidator {
    public static void main(String[] args) {
        String[] urls = {
                "http://www.onet.pl",
                "https://mail.google.com",
                "http://wiadmosci.onet.pl",
                "http://onet.pl"
        };

        for (String url : urls) {
            boolean isURL = validateURL(url);
            if (isURL) {
                System.out.println("URL: " + url + " is valid");
            } else {
                System.out.println("URL: " + url + " is not valid");
            }
        }
    }

    private static boolean validateURL(String url) {
        String urlRegex = "^" +                        // Start of the string
                "(https?://)?" +              // Optional "http://" or "https://"
                "([a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})" +  // Domain name (letters, digits, dots, hyphens)
                "(/\\S*)?$";                // Optional path after the domain and end of the string

        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}
