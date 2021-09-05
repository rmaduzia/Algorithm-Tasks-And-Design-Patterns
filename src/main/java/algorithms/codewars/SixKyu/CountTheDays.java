package algorithms.codewars.SixKyu;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CountTheDays {

    public String countDays(Date d){

        Date now = new Date();
        int result = d.compareTo(now);

        if (result == 0) {
            return "Today is the day!";
        } if (result < 0 ) {
            return "The day is in the past!";
        } else {
            long diff = d.getTime() - now.getTime();
            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) +  " days";
        }
    }
}