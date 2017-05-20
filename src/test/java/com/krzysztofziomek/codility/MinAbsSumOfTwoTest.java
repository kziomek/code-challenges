package com.krzysztofziomek.codility;

import org.junit.Assert;

/**
 * @author Krzysztof Ziomek
 * @since 20/05/2017.
 */
public class MinAbsSumOfTwoTest {

    @org.junit.Test
    public void solution() throws Exception {
        Assert.assertEquals(3, new MinAbsSumOfTwo().solution(new int[]{-8, 4, 5, -10, 3}));
        Assert.assertEquals(2, new MinAbsSumOfTwo().solution(new int[]{1, 2, 3, 4}));
        Assert.assertEquals(2, new MinAbsSumOfTwo().solution(new int[]{-1, -1, -1, -1}));
        Assert.assertEquals(0, new MinAbsSumOfTwo().solution(new int[]{0, -1, 1}));
        Assert.assertEquals(0, new MinAbsSumOfTwo().solution(new int[]{2, 2, -2, -2, 0}));
        Assert.assertEquals(2, new MinAbsSumOfTwo().solution(new int[]{1}));
    }


}