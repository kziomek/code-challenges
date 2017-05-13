package com.krzysztofziomek.codility;

import org.junit.Assert;

/**
 * @author Krzysztof Ziomek
 * @since 13/05/2017.
 */
public class LadderTest {
    @org.junit.Test
    public void solution() throws Exception {

        int[] solution = new Ladder().solution(new int[]{4, 4, 5, 5, 1}, new int[]{3, 2, 4, 3, 1});
        Assert.assertArrayEquals(new int[]{5, 1, 8, 0, 1}, solution);

    }

}