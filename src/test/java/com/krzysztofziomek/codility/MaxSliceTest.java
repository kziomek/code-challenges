package com.krzysztofziomek.codility;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 01/05/2017.
 */
public class MaxSliceTest {

    @Test
    public void solution() throws Exception {
        Assert.assertEquals(5, new MaxSlice().solution(new int[]{3, 2, -6, 4, 0}));
        Assert.assertEquals(-1, new MaxSlice().solution(new int[]{-1, -5, -6, -3, -2}));
        Assert.assertEquals(5, new MaxSlice().solution(new int[]{4, -2, 3}));
        Assert.assertEquals(1, new MaxSlice().solution(new int[]{-2, 1}));
        Assert.assertEquals(-1, new MaxSlice().solution(new int[]{-5, -4, -3,-2, -1}));
    }

}