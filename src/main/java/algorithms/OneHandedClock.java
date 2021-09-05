package algorithms;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class OneHandedClock {

    public static String execute(int number) {

        if ((number < 0) || (number > 359)) {
            return "Give number beetwen 0 and 359";
        }
        else if (number == 0){
            return "12:00";
        }

        int minutesToAdd = number*2;

        String timeColonPattern = "HH:mm";
        DateTimeFormatter timeColonFormatter = DateTimeFormatter.ofPattern(timeColonPattern);
        LocalTime colonTime = LocalTime.of(0, 0);

        return timeColonFormatter.format(colonTime.plusMinutes(minutesToAdd));
    }

}
