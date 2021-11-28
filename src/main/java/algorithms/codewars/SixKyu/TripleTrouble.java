package algorithms.codewars.SixKyu;

public class TripleTrouble {

    public static int TripleDouble(long num1, long num2)
    {
        String num1AsString = String.valueOf(num1);
        String num2AsString = String.valueOf(num2);

        for (int i=0; i<num1AsString.length(); i++) {

            char c = num1AsString.charAt(i);
            if(num1AsString.contains(new String(new char[]{c, c, c})) &&
                    num2AsString.contains(new String(new char[] {c, c})))
                return 1;
        }

        return 0;
    }
}
