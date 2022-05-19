package algorithms.codewars.SixKyu;

public class PizzaPieces {

    public static int maxPizza(int cuts) {

        if (cuts < 0)
            return -1;
        if (cuts == 0)
            return 1;
        return (cuts * (cuts +1) / 2) +1 ;
    }
}
