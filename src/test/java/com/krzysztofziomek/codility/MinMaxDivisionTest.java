package com.krzysztofziomek.codility;

import org.junit.Assert;

/**
 * @author Krzysztof Ziomek
 * @since 18/05/2017.
 */
public class MinMaxDivisionTest {

    @org.junit.Test
    public void solution() throws Exception {

        MinMaxDivision minMaxDivision = new MinMaxDivision();

        int K = 3;
        int M = 5;
        int[] A = new int[]{2, 1, 5, 1, 2, 2, 2};

        Assert.assertEquals(6, minMaxDivision.solution(K, M, A));

    }

    @org.junit.Test
    public void solutionForOneElement() throws Exception {

        MinMaxDivision minMaxDivision = new MinMaxDivision();

        int K = 3;
        int M = 5;
        int[] A = new int[]{2};

        Assert.assertEquals(2, minMaxDivision.solution(K, M, A));

    }

    @org.junit.Test
    public void solutionForKEquals1() throws Exception {

        MinMaxDivision minMaxDivision = new MinMaxDivision();

        int K = 1;
        int M = 5;
        int[] A = new int[]{2, 1, 5, 1, 2, 2, 2};

        Assert.assertEquals(15, minMaxDivision.solution(K, M, A));

    }

    @org.junit.Test
    public void solutionForKGreatherThanALenght() throws Exception {

        MinMaxDivision minMaxDivision = new MinMaxDivision();

        int K = 10;
        int M = 5;
        int[] A = new int[]{2, 1, 5, 1, 2, 2, 2};

        Assert.assertEquals(5, minMaxDivision.solution(K, M, A));

    }

}