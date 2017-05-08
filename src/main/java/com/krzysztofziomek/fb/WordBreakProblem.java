package com.krzysztofziomek.fb;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Krzysztof Ziomek
 * @since 08/05/2017.
 */
public class WordBreakProblem {

    Set<String> dictionary = new HashSet<>();

    public WordBreakProblem() {
        dictionary.add("i");
        dictionary.add("like");
        dictionary.add("sam");
        dictionary.add("sung");
        dictionary.add("samsung");
        dictionary.add("mobile");
        dictionary.add("ice");
        dictionary.add("cream");
        dictionary.add("icecream");
        dictionary.add("man");
        dictionary.add("go");
        dictionary.add("mango");
    }

    public boolean wordBreakRecursive(String str) {
        if (str.isEmpty()) {
            return true;
        }
        for (int i = 1; i <= str.length(); i++) {
            if (dictionary.contains(str.substring(0, i)) && wordBreakRecursive(str.substring(i, str.length()))) {
                return true;
            }
        }
        return false;
    }

    public int wordBreak(String str) {
        int[] t = new int[str.length() + 1];
        Arrays.fill(t, -1);
        t[0] = 0;

        for (int i = 0; i < str.length(); i++) {
            if (t[i] != -1) {

                for (int j = i + 1; j <= str.length(); j++) {
                    if (dictionary.contains(str.substring(i, j))) {
                        t[j] = i;
                    }

                }
            }
        }
        return t[str.length()];
    }


}
