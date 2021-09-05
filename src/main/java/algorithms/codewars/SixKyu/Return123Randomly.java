package algorithms.codewars.SixKyu;

public class Return123Randomly {

    public static int oneTwoThree() {

        int a = 1;//int a = oneTwo();
        int b = 2;//int b = oneTwo();

        if (a == 1 && b == 2)
            return 1;
        if (a == 2 && b == 1)
            return 2;
        if (b == 1 && b == 1)
            return 3;

        return oneTwoThree();
    }
}
