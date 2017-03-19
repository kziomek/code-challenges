package com.krzysztofziomek.palindrome;

/**
 * @author Krzysztof Ziomek
 * @since 19/03/2017.
 */
public class Palindrome {

    public boolean isPalindrome(String string) {
        if (string == null) {
            return false;
        }

        char[] chars = string.toCharArray();
        int length = chars.length;

        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
