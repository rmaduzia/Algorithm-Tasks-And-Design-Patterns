package algorithms.spoj.tutorial.blue;

import java.util.Arrays;
import java.util.Scanner;

public class AE1BTables {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        int amountOfBoxes = scanner.nextInt();
        int screwsNeedForEachTable = scanner.nextInt();
        int tablesToMake = scanner.nextInt();
        int amountOfDeededScrews = screwsNeedForEachTable * tablesToMake;

        int[] screwsInBoxes = new int[amountOfBoxes];
        int counter  = 0;
        int temp = 0;

        for (int i=0; i<amountOfBoxes; i++){
            screwsInBoxes[i] = scanner.nextInt();
        }

        Arrays.sort(screwsInBoxes);
        for (int j=screwsInBoxes.length-1; j>=0;j--) {
            temp += screwsInBoxes[j];
            counter +=1;
            if (temp >= amountOfDeededScrews) {
                break;
            }

        }
        System.out.println(counter);
    }
}
