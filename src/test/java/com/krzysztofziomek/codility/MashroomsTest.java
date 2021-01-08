package com.krzysztofziomek.codility;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 08/01/2021.
 */
public class MashroomsTest {

    @Test
    public void test() {
        // hit left and right bounds
        Assert.assertEquals(25, new Mashrooms().solution(new int[]{2, 3, 7, 5, 1, 3, 9}, 4, 6));
        // hit left bound
        Assert.assertEquals(16, new Mashrooms().solution(new int[]{2, 3, 7, 5, 1, 3, 9}, 2, 3));
        // hit right bound
        Assert.assertEquals(16, new Mashrooms().solution(new int[]{2, 3, 7, 5, 1, 3, 9}, 4, 3));
        // hit left bound after turn
        Assert.assertEquals(19, new Mashrooms().solution(new int[]{2, 3, 7, 5, 1, 3, 9}, 1, 4));
        // hit right bound after turn
        Assert.assertEquals(19, new Mashrooms().solution(new int[]{2, 3, 7, 5, 1, 3, 9}, 5, 4));
        // hit all bounds
        Assert.assertEquals(30, new Mashrooms().solution(new int[]{2, 3, 7, 5, 1, 3, 9}, 5, 100));
    }
}