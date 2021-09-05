package algorithms.spoj.classical.blue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


//TODO MAKE RESEARCH ABOUT REGEX
public class MAIN12CEmailID {

//TODO MAKE RESEARCH ABOUT REGEX
    public static void main(String[] args)  {

        Scanner scanner  = new Scanner(System.in);


        int amountOfLines = scanner.nextInt();

        scanner.nextLine();

        String regex = "^[a-zA-Z0-9]{5,10}$";

        while (amountOfLines >0) {


           String temp = scanner.nextLine();


            String[] array = temp.split(" ", 0);

            for (int i=0; i<array.length; i++) {

                if (array[i].codePoints().filter(ch -> ch =='@').count() < 2 ) {
                    String emailName = array[i].split("@")[0];

                    String emailDomainName = array[i].split("@")[1];




                    System.out.println("first email: " + array[i]);
                }
            }

            System.out.println(Arrays.toString(array));




            amountOfLines--;

        }





    }

}
