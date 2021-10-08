package algorithms.codewars.SixKyu;

public class Dubstep {

    public static String SongDecoder (String song)
    {
        return song.replaceAll("(WUB)+", " ").trim();
    }
}
