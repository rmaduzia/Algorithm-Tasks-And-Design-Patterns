package algorithms.codewars.SixKyu;

public class GiveMeADiamond {

    public static String print(int n) {

        if (n < 0 || n % 2 == 0)
            return null;

        StringBuilder result = new StringBuilder();

        int center = n / 2 +1;

        for(int i=1; i<=n; i++) {
            int spaces = Math.abs(center - i);
            result.append(" ".repeat(spaces));
            result.append("*".repeat(n - spaces * 2));
            result.append("\n");
        }
        return result.toString();
    }
}
