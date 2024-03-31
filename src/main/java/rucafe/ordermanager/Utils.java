package rucafe.ordermanager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static Donut stringToDonut(String string) {
        Pattern pattern = Pattern.compile("^(.+)\\((\\d+)\\)$");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            String flavor = matcher.group(1);
            int quantity = Integer.parseInt(matcher.group(2));
            return new Donut(null, flavor, quantity);
        } else {
            return null;
        }
    }

    public static Coffee stringToCoffee(String string) {

        return null;
    }

    public static Sandwich stringToSandwich(String string) {

        return null;
    }
}
