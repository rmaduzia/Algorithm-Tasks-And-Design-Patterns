package algorithms.codewars.SixKyu;

public class SumOfDigitsDigitalRoot {

    public static int digital_root(int n) {
        return (n - 1) % 9 + 1;
    }
}