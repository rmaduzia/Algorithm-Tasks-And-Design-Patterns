package algorithms.codewars.SixKyu;

public class WriteNumberInExpandedForm {

    public static String expandedForm(int num)
    {
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(num);

        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) != '0') {
                sb.append(s.charAt(i));

                if(i != s.length() - 1){
                    sb.append("0".repeat(s.length()-i-1));
                }

                if(i != s.length() - 1 && s.charAt(s.length()-1) != '0') {
                    sb.append(" + ");
                }
            }
        }
        return sb.toString();
    }
}
