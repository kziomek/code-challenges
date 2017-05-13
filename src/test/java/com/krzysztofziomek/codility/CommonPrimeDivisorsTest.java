package com.krzysztofziomek.codility;

import org.junit.Assert;

/**
 * @author Krzysztof Ziomek
 * @since 13/05/2017.
 */
public class CommonPrimeDivisorsTest {

    @org.junit.Test
    public void solution() throws Exception {
        CommonPrimeDivisors commonPrimeDivisors = new CommonPrimeDivisors();
        Assert.assertEquals(1, commonPrimeDivisors.solution(new int[]{15, 10, 3}, new int[]{75, 30, 5}));
    }

}