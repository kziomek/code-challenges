package com.krzysztofziomek.codility;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 29/04/2017.
 */
public class CountDistinctSlicesTest {

    @Test
    public void test() {

        CountDistinctSlices countDistinctSlices = new CountDistinctSlices();

        Assert.assertEquals(9, countDistinctSlices.solution(6, new int[]{3, 4, 5, 5, 2}));
        Assert.assertEquals(3, countDistinctSlices.solution(3, new int[]{1, 2}));
        Assert.assertEquals(2, countDistinctSlices.solution(3, new int[]{3, 3}));
        Assert.assertEquals(18, countDistinctSlices.solution(6, new int[]{1, 2, 3, 4, 5, 5, 6}));
        Assert.assertEquals(17, countDistinctSlices.solution(6, new int[]{1, 2, 3, 4, 2, 5}));
        Assert.assertEquals(4, countDistinctSlices.solution(6, new int[]{1, 1, 1, 1}));
        Assert.assertEquals(7, countDistinctSlices.solution(2, new int[]{1, 2, 1, 2}));
        Assert.assertEquals(15, countDistinctSlices.solution(15, new int[]{1, 2, 3, 1, 2, 3}));
        Assert.assertEquals(1, countDistinctSlices.solution(1, new int[]{1}));
        Assert.assertEquals(1, countDistinctSlices.solution(1, new int[]{0}));

    }


}