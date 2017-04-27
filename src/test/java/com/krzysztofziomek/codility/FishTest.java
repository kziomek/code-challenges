package com.krzysztofziomek.codility;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 27/04/2017.
 */
public class FishTest {
    @Test
    public void testA() throws Exception {
        Fish fish = new Fish();

        long[] A = new long[]{4, 3, 2, 1, 5};
        long[] B = new long[]{0, 1, 0, 0, 0};

        Assert.assertEquals(2, fish.solution(A, B));

    }

    @Test
    public void testAllFishSwimUpstream() throws Exception {
        Fish fish = new Fish();

        long[] A = new long[]{4, 3, 2, 1, 5};
        long[] B = new long[]{0, 0, 0, 0, 0};

        Assert.assertEquals(5, fish.solution(A, B));

    }

    @Test
    public void testAllFishSwimDownstream() throws Exception {
        Fish fish = new Fish();

        long[] A = new long[]{4, 3, 2, 1, 5};
        long[] B = new long[]{0, 0, 0, 0, 0};

        Assert.assertEquals(5, fish.solution(A, B));

    }

    @Test
    public void testFishGoOnStackAndLastBiggest() throws Exception {
        Fish fish = new Fish();

        long[] A = new long[]{4, 3, 2, 1, 5};
        long[] B = new long[]{1, 1, 1, 1, 0};

        Assert.assertEquals(1, fish.solution(A, B));

    }

}