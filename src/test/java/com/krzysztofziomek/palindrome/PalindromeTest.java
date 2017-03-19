package com.krzysztofziomek.palindrome;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 19/03/2017.
 */
public class PalindromeTest {

    Palindrome palindrome;

    @Before
    public void setUp() {
        palindrome = new Palindrome();
    }

    @Test
    public void nullStringIsNotPalindrome() {
        // prepare
        String s = null;

        // execute
        boolean result = palindrome.isPalindrome(s);

        // assert
        Assert.assertFalse(result);

    }

    @Test
    public void emptyStringIsPalindrome() {
        // prepare
        String s = "";

        // execute
        boolean result = palindrome.isPalindrome(s);

        // assert
        Assert.assertTrue(result);

    }

    @Test
    public void singleCharIsPalindrome() {
        // prepare
        String s = "A";

        // execute
        boolean result = palindrome.isPalindrome(s);

        // assert
        Assert.assertTrue(result);

    }

    @Test
    public void string_11_isPalindrome() {
        // prepare
        String s = "11";

        // execute
        boolean result = palindrome.isPalindrome(s);

        // assert
        Assert.assertTrue(result);

    }

    @Test
    public void string_12_isNotPalindrome() {
        // prepare
        String s = "12";

        // execute
        boolean result = palindrome.isPalindrome(s);

        // assert
        Assert.assertFalse(result);

    }

    @Test
    public void string_121_isPalindrome() {
        String s = "121";

        // execute
        boolean result = palindrome.isPalindrome(s);

        // assert
        Assert.assertTrue(result);

    }

    @Test
    public void should_1221_BePlindrome() {
        String s = "1221";

        // execute
        boolean result = palindrome.isPalindrome(s);

        // assert
        Assert.assertTrue(result);

    }

    @Test
    public void shouldnt_1121_bePalindrome() {
        String s = "1121";
        Palindrome palindrome = new Palindrome();

        // execute
        boolean result = palindrome.isPalindrome(s);

        // assert
        Assert.assertFalse(result);

    }

}