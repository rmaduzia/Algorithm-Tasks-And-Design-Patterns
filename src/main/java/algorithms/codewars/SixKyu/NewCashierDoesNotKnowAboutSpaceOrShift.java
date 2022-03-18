package algorithms.codewars.SixKyu;

import java.util.List;

public class NewCashierDoesNotKnowAboutSpaceOrShift {

    public static String getOrder(String input) {

        List<String> menu = List.of("burger", "fries", "chicken", "pizza",
                "sandwich", "onionrings", "milkshake", "coke");

        StringBuilder result = new StringBuilder();
        int occurancesOfFood = 1;
        for(String s: menu) {
            if (input.contains(s)) {
                occurancesOfFood = input.split(s, -1).length -1;
                result.append((s.substring(0,1).toUpperCase() + s.substring(1) + " ").repeat(occurancesOfFood));
            }
        }
        return result.toString().trim();
    }
}
