package algorithms.codewars.SixKyu;

public class PersistentBugger {

    public static int persistence(long n) {
        int counter = 0;

        while (n > 9) {
            long multiply  = 1;

            for (char t: String.valueOf(n).toCharArray()) {
                multiply  *= Long.parseLong(String.valueOf(t));
            }
            n = multiply ;
            counter++;
        }
        return counter;
    }
}