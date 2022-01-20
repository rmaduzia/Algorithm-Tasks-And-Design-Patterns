package algorithms.codewars.SixKyu;

public class BouncingBalls {

    public static int bouncingBall(double h, double bounce, double window) {

        if(h != 0 && bounce > 0 && bounce < 1 && window < h) {

            double current = h * bounce;
            int counter = 1;

            while (current > window) {
                current *= bounce;
                counter +=2;
            }
            return counter;
        } else {
            return -1;
        }
    }
}
