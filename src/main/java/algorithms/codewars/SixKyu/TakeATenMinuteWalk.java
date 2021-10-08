package algorithms.codewars.SixKyu;

public class TakeATenMinuteWalk {

    public static boolean isValid(char[] walk) {

        int ns = 0;
        int we = 0;

        for(char c: walk) {
            if (c == 'n')
                ns++;
            if (c == 's')
                ns--;
            if (c == 'w')
                we++;
            if (c == 'e')
                we--;
        }

        return walk.length == 10 && ns == 0 && we == 0;
    }
}
