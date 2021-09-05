package algorithms.codewars.SixKyu;

public class GetExcelColumnTitle {

    public static String getColumnTitle(int num) {

        if (num <= 0)
            throw new IllegalArgumentException("The Number can't be zero");

        StringBuilder result = new StringBuilder();

        while(num > 0) {
            int mod = num % 26;

            if (mod ==  0) {
                result.append("Z");
                num = (num / 26 ) -1;
            } else {
                result.append((char) ((mod - 1) + 'A'));
                num = num / 26;
            } }
        return result.reverse().toString();
    }
}