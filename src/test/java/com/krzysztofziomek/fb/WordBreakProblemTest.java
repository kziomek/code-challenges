package com.krzysztofziomek.fb;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Krzysztof Ziomek
 * @since 08/05/2017.
 */
public class WordBreakProblemTest {

    @Test
    public void testWordBreakRecursive() throws Exception {

        WordBreakProblem wordBreakProblem = new WordBreakProblem();
        assertTrue(wordBreakProblem.wordBreakRecursive(""));
        assertTrue(wordBreakProblem.wordBreakRecursive("ilikesamsung"));
        assertTrue(wordBreakProblem.wordBreakRecursive("ilikelikeimangoiii"));

    }

    @Test
    public void testWordBreak() throws Exception {

        WordBreakProblem wordBreakProblem = new WordBreakProblem();
        assertTrue(wordBreakProblem.wordBreak("") > -1);
        assertTrue(wordBreakProblem.wordBreak("ilikesamsung") > -1);
        assertTrue(wordBreakProblem.wordBreak("ilikelikeimangoiii") > -1);

    }

}