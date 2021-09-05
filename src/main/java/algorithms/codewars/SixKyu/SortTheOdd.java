package algorithms.codewars.SixKyu;

public class SortTheOdd {

    public static int[] sortArray(int[] array) {

        int temp=0;

        for (int i=0; i<array.length; i++) {
            if(array[i] %2 !=0 ) {
                for (int j=i; j<array.length; j++) {
                    if(array[j] %2 !=0 && array[i] > array[j]) {
                        temp = array[j];
                        array[j] = array[i];
                        array[i] = temp;
                    }
                }
            }
        }
        return array;
    }
}
