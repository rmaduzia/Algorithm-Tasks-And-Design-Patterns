package algorithms.codewars.SixKyu;

public class BuildTower {

    public static String[] TowerBuilder(int nFloors)
    {
        String[] result = new String[nFloors];
        StringBuilder sb = new StringBuilder();

        for (int i=nFloors; i>0; i--) {
            sb.append(" ".repeat(nFloors - i));
            sb.append("*".repeat((2 * i) -1));
            sb.append(" ".repeat(nFloors - i));
            result[i-1] = sb.toString();
            sb.setLength(0);
        }

        return result;
    }
}