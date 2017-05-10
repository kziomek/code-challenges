package com.krzysztofziomek.recursive;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Krzysztof Ziomek
 * @since 10/05/2017.
 */
public class WordsFromPhoneDigitsTest {

    @Test
    public void shouldReturnArrayOf9CombinedElements() throws Exception {

        String input = "12";
        Map<Character, String> map = new HashMap<>();
        map.put('1', "ABC");
        map.put('2', "DEF");
        map.put('3', "GHI");

        List<String> output = new LinkedList<>();
        new WordsFromPhoneDigits().getStrings(input, "", 0, map, output);

        Assert.assertArrayEquals(new String[]{"AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF"}, output.toArray());
        System.out.println("done");

    }

}