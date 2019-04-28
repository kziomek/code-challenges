package com.krzysztofziomek.codility;

import org.junit.Assert;

/**
 * @author Krzysztof Ziomek
 * @since 12/05/2017.
 */
public class CountSemiprimesTest {

    @org.junit.Test
    public void solution() throws Exception {

        CountSemiPrimes sieveOfEratoSthenes = new CountSemiPrimes();

        int[] P = new int[]{1, 4, 16};
        int[] Q = new int[]{26, 10, 20};

        int N = 26;
        int[] result = sieveOfEratoSthenes.solution(N, P, Q);
        Assert.assertArrayEquals(new int[]{10, 4, 0}, result);
    }

}