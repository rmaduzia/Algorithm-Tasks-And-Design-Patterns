package algorithms.codewars.SixKyu;

public class StringArrayDuplicates {

    public static String[] dup(String[] arr){

        String[] result = new String[arr.length];
        StringBuilder formattedString = new StringBuilder();

        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length(); j++) {

                if (j == arr[i].length()-1) {
                    formattedString.append(arr[i].charAt(j));
                    break;
                }
                if (arr[i].charAt(j) != arr[i].charAt(j+1)) {
                    formattedString.append(arr[i].charAt(j));
                }
            }
            result[i] = formattedString.toString();
            formattedString.setLength(0);
        }
        return result;
    }
}
