package algorithms.codewars.SixKyu;

public class CreatePhoneNumber {

    public static String createPhoneNumber(int[] numbers) {

        StringBuilder sb = new StringBuilder();
        sb.append("(");

        for (int i=0; i<3; i++) {
            sb.append(numbers[i]);
        }
        sb.append(") ");
        for(int i=3; i<6; i++) {
            sb.append(numbers[i]);
        }
        sb.append("-");
        for (int i=6; i<numbers.length; i++) {
            sb.append(numbers[i]);
        }
        return sb.toString();
    }
}