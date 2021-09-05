package algorithms.spoj.bacics.blue;

import java.util.*;

public class CPTTRN1CharacterPatternsAct1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int amountOfCases = scan.nextInt();
        StringBuilder oneLine;

        for (int i=0; i<amountOfCases; i++) {

            int rows = scan.nextInt();
            int columns = scan.nextInt();

            for (int r=0; r< rows; r++) {
                oneLine = new StringBuilder();
                for (int c = 0; c<columns; c++) {
                    if (r % 2 == 0){
                        if (c % 2 == 0){
                            oneLine.append("*");
                        } else {
                            oneLine.append(".");
                        }
                    } else {
                        if (c % 2 != 0){
                            oneLine.append("*");
                        } else {
                            oneLine.append(".");
                        }
                    }
                }
                System.out.println(oneLine);
            }
        }
    }
}
