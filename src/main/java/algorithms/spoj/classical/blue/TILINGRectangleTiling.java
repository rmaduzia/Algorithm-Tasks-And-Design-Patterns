package algorithms.spoj.classical.blue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TILINGRectangleTiling {


    //TODO DOKONCZYC
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int amountOfCases = scanner.nextInt();

        int rowCounter = scanner.nextInt();
        int columnCounter = scanner.nextInt();

        StringBuilder allCharsInCase = new StringBuilder();

        List<Character> listOfCharacters = new ArrayList<>();

        List<String> linesInCase = new ArrayList<>();
        int counter = 0;

        for (int i=0; i<amountOfCases;i++) {
            for (int j=0; j< rowCounter+1; j++) {
                allCharsInCase.append(scanner.nextLine());
            }
           // System.out.println(allCharsInCase);

            for (int c=0; c<allCharsInCase.length(); c++) {

                if (!listOfCharacters.contains(allCharsInCase.charAt(c))) {
                    listOfCharacters.add(allCharsInCase.charAt(c));
                    System.out.println(c+1);
                    //counter += 1;
                }

               // System.out.println(allCharsInCase.charAt(c));
            }
        }


        System.out.println(counter);


       // System.out.println(Arrays.toString(linesInCase.toArray()));








    }

}
