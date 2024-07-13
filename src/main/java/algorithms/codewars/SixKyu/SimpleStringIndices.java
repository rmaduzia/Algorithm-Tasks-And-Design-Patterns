package algorithms.codewars.SixKyu;

public class SimpleStringIndices {

    public static int solve(String str, int index){

        if (str.charAt(index)!='(')
            return -1;

        int count=1;
        for (int i=index+1;i<str.length();i++){
            if (str.charAt(i)=='('){
                count++;
            }
            if (str.charAt(i)==')'){
                count--;
            }
            if (count==0){
                return i;
            }
        }
        return -1;
    }
}
