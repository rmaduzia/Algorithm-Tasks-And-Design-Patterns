package algorithms.codewars.SixKyu;

public class VasyaClerk {

    public static String Tickets(int[] peopleInLine)
    {
        int amount25 = 0;
        int amount50 = 0;
        int oneBiletPrice = 25;

        for (int value: peopleInLine) {

            if (value == oneBiletPrice) {
                amount25++;
            }
            if (value == oneBiletPrice * 2) {
                amount25 -= 1;
                amount50 += 1;
            }
            if (value == oneBiletPrice * 4) {
                if (amount50 == 0 && amount25 >=3 ) {
                    amount25 -= 3;
                } else {
                    amount25 -= 1;
                    amount50 -= 1;
                }
            }
            if (amount25 < 0 || amount50 < 0) {
                return "NO";
            }
        }
        return "YES";
    }
}