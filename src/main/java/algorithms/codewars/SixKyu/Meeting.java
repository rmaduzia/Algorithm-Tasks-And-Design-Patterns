package algorithms.codewars.SixKyu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Meeting {


    public static String meeting(String s) {

        s = s.toUpperCase();
        List<String> listOfNames = new ArrayList<>();

        String[] sArray = s.split(";");
        for (String v: sArray) {
            listOfNames.add("("+ v.split(":")[1] + ", " + v.split(":")[0] + ")");
        }
        Collections.sort(listOfNames);

        return String.join("", listOfNames);
    }
}
