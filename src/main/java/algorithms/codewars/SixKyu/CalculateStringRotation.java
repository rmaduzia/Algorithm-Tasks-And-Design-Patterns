package algorithms.codewars.SixKyu;

public class CalculateStringRotation {

    static int shiftedDiff(String first, String second){

        if(first.length() != second.length())
            return -1;
        return (second+second).indexOf(first);
    }
}
