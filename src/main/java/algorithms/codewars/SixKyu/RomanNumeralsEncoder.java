package algorithms.codewars.SixKyu;

import java.util.TreeMap;

public class RomanNumeralsEncoder {

    static TreeMap<Integer, String> romanNumerals = new TreeMap<>();

    public String solution(int n) {

        romanNumerals.put(1000, "M");
        romanNumerals.put(900, "CM");
        romanNumerals.put(500, "D");
        romanNumerals.put(400, "CD");
        romanNumerals.put(100, "C");
        romanNumerals.put(90, "XC");
        romanNumerals.put(50, "L");
        romanNumerals.put(40, "XL");
        romanNumerals.put(10, "X");
        romanNumerals.put(9, "IX");
        romanNumerals.put(5, "V");
        romanNumerals.put(4, "IV");
        romanNumerals.put(1, "I");

        return RomanNumeralsEncoder.toRoman(n);
    }

    public static String toRoman(int number) {
        int l =  romanNumerals.floorKey(number);
        if ( number == l ) {
            return romanNumerals.get(number);
        }
        return romanNumerals.get(l) + toRoman(number-l);
    }


}
