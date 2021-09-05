package algorithms;

public class IsEgoisticNumber {

    public static boolean execute(int number) {

        int pow = number * number;
        int lastNumber = pow %10 ;

        return lastNumber == number;

    }
}
