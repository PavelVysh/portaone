import java.util.*;
import java.util.stream.Collector;

public class Main {

    public static void main(String[] args) {

        String test = "C makes it easy for you to shoot yourself in the foot." + " C++ makes that harder, but when you do, it blows away your whole leg. (с) Bjarne Stroustrup";

        System.out.println(getLetter(test));

    }

    public static char getLetter(String string) {
        String[] words = getWords(string);

        String resultString = Arrays.stream(words)
                .map(Main::getFirstUniqueChar)
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString));

        return getFirstUniqueChar(resultString);
    }

    public static String[] getWords(String string) {
        return string.replaceAll("[^\\w\\s]", "").split("\\s+");
    }

    public static Character getFirstUniqueChar(String string) {
        Map<Character, Integer> countChars = new HashMap<>();
        char[] chars = string.toCharArray();

        for (char s : chars) {
            countChars.put(s, countChars.getOrDefault(s, 0) + 1);
        }
        for (char s : chars) {
            if (countChars.get(s) == 1) {
                return s;
            }
        }
        return null;
    }

}