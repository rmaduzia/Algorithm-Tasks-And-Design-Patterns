package algorithms.codewars.SixKyu;

public class BackspacesInString {

    public String cleanString(String s) {

        StringBuilder sb = new StringBuilder();
        int counter=0;

        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) != '#') {
                if (counter > 0 ) {
                    counter--;
                }
                else if (counter == 0) {
                    System.out.println(s.charAt(i) + " | " + i);
                    sb.append(s.charAt(i));
                }
            } else {
                counter++;
                System.out.println(counter);
            }
        }
        return sb.reverse().toString();
    }
}
