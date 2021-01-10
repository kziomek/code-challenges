package com.krzysztofziomek.palindrome;

/**
 * @author Krzysztof Ziomek
 * @since 19/03/2017.
 *
 * Write an efficient algorithm to check if a string is a palindrome. A string is a palindrome if the string matches the reverse of string.
 * Example: 1221 is a palindrome but not 1121.
 *
 * Algorithm complexity is O(n)
 */
public class Palindrome {

    public boolean isPalindrome(String string) {
        if (string == null) {
            return false;
        }

        char[] c = string.toCharArray();
        int l=0, r=c.length-1;

        while (l < r) {
            if (c[l] != c[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}