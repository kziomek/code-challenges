package com.krzysztofziomek.recursive;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Krzysztof Ziomek
 * @since 10/05/2017.
 */
public class WordsFromPhoneDigits {


    public void getStrings(String input, String s, int level, Map<Character, String> map, List<String> output) {
        if (level == input.length()) {
            output.add(s);
            return;
        }

        for (char c : map.get(input.charAt(level)).toCharArray()) {
            getStrings(input, s + c, level + 1, map, output);
        }

    }

    public static void main(String[] args) {
        String input = "12";
        Map<Character, String> map = new HashMap<>();
        map.put('1', "ABC");
        map.put('2', "DEF");
        map.put('3', "GHI");

        List<String> output = new LinkedList<>();
        new WordsFromPhoneDigits().getStrings(input, "", 0, map, output);
        System.out.println("done");

    }
}
