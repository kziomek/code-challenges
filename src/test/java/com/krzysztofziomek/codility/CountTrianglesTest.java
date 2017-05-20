package com.krzysztofziomek.codility;

import org.junit.Assert;

/**
 * @author Krzysztof Ziomek
 * @since 20/05/2017.
 */
public class CountTrianglesTest {

    @org.junit.Test
    public void solution() throws Exception {
        Assert.assertEquals(20, new CountTriangles().solution(new int[]{5, 6, 7, 8, 9, 10}));
        Assert.assertEquals(4, new CountTriangles().solution(new int[]{10, 2, 5, 1, 8, 12}));
        Assert.assertEquals(0, new CountTriangles().solution(new int[]{}));
        Assert.assertEquals(0, new CountTriangles().solution(new int[]{1}));
        Assert.assertEquals(0, new CountTriangles().solution(new int[]{1, 2}));
    }

}