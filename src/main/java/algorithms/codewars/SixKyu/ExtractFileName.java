package algorithms.codewars.SixKyu;

public class ExtractFileName {

    public static String extractFileName(String dirtyFileName) {

        String result = dirtyFileName.substring(dirtyFileName.indexOf("_") + 1);
        result = result.substring(0,result.lastIndexOf("."));
        return result;
    }
}
