package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {
    public static void main(String[] args) {
//        String s1 = "ABCD ABCE ABCFABCGABCH";
//        Pattern pattern1 = Pattern.compile("ABC"); // соответствует последовательно идущим abc

        String s1 = "abcd abce abcf abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc(e|5)");
        Pattern pattern1 = Pattern.compile("abc.");

        Matcher matcher = pattern1.matcher(s1);
        while (matcher.find()) {
            System.out.println("Position: " + matcher.start() + " " + matcher.group());
        }
    }
}
