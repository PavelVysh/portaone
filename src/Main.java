import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String test = "C makes it easy for you to shoot yourself in the foot." +
                " C++ makes that harder, but when you do, it blows away your whole leg. (с) Bjarne Stroustrup";

        System.out.println(getLetter(test));

    }

    public static char getLetter(String string) {
        String[] words = getWords(string);
        List<Character> chars = getFirstChars(words);
        return getUniqueChar(chars);
    }

    public static String[] getWords(String string) {
        return string.replaceAll("[^\\w\\s]", "").split("\\s+");
    }

    public static List<Character> getFirstChars(String[] strings) {
        List<Character> chars = new ArrayList<>();

        for (String s : strings) {
            Map<Character, Integer> countChars = new HashMap<>();
            for (char c : s.toCharArray()) {
                countChars.put(c, countChars.getOrDefault(c, 0) + 1);
            }
            for (char c : s.toCharArray()) {
                if (countChars.get(c) == 1) {
                    chars.add(c);
                    break;
                }
            }
        }
        return chars;
    }

    public static Character getUniqueChar(List<Character> chars) {
        Map<Character, Integer> countChars = new HashMap<>();
        for (char c : chars) {
            countChars.put(c, countChars.getOrDefault(c, 0) + 1);
        }
        for (char c : chars) {
            if (countChars.get(c) == 1) {
                return c;
            }
        }
        return null;
    }

}