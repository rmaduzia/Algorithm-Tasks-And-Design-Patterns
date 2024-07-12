package algorithms.codewars.SixKyu;

public class BinaryToTextASCIIConversion {

    public static String binaryToText(String binary) {

        StringBuilder result = new StringBuilder();
        int index=0;

        while(index < binary.length()) {
            String charString = binary.substring(index, Math.min(index+8, binary.length()));
            index += 8;

            int charCode = Integer.parseInt(charString, 2);
            String str = Character.toString((char) charCode);
            result.append(str);

        }
        return result.toString();
    }
}
