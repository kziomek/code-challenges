package com.krzysztofziomek.codility.dynamic;

import org.junit.Assert;

/**
 * @author Krzysztof Ziomek
 * @since 21/05/2017.
 */
public class NumberSolitaireTest {

    @org.junit.Test
    public void solution() throws Exception {
        Assert.assertEquals(8, new NumberSolitaire().solution(new int[]{1, -2, 0, 9, -1, -2}));
    }

}