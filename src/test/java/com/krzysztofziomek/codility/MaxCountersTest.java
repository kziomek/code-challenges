package com.krzysztofziomek.codility;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Krzysztof Ziomek
 * @since 26/04/2017.
 */
public class MaxCountersTest {

    @Test
    public void solution() throws Exception {

        MaxCounters maxCounters = new MaxCounters();
        int[] commands = {3, 4, 4, 6, 1, 4, 4};
        int N = 5;

        int[] solution = maxCounters.solution(N, commands);

        System.out.println(Arrays.toString(solution));
        Assert.assertArrayEquals(new int[]{3, 2, 2, 4, 2}, solution);
    }

}