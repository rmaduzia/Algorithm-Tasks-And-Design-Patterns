package algorithms.codewars.SixKyu;

public class YourOrderPlease {

    public static String order(String words) {

        String[] tabWords = words.split(" ");
        String[] tabResultsSorted = new String[tabWords.length];

        if (words.isEmpty()) {
            return "";
        }

        int num = 0;
        for (String value: tabWords) {
            for (char ch: value.toCharArray())
            {
                if (Character.isDigit(ch)) {
                    num = Character.getNumericValue(ch);
                }
            }
            tabResultsSorted[num - 1] = value;
        }
        return String.join(" ", tabResultsSorted);
    }
}
