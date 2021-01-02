package com.krzysztofziomek.codility;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 18/05/2017.
 */
public class NailingPlanksTest {

    @Test
    public void shouldReturnNumberOfNailsToCoverPlanks() {

        NailingPlanks nailingPlanks = new NailingPlanks();

        int[] A = new int[]{1, 4, 5, 8};
        int[] B = new int[]{4, 5, 9, 10};
        int[] C = new int[]{4, 6, 7, 10, 2};

        Assert.assertEquals(4, nailingPlanks.solution(A, B, C));

    }

    @org.junit.Test
    public void shouldReturnNumberOfNailsToCoverPlanks5() {

        NailingPlanks nailingPlanks = new NailingPlanks();

        int[] A = new int[]{1, 4, 5, 8};
        int[] B = new int[]{4, 5, 9, 10};
        int[] C = new int[]{4, 6, 7, 2, 10};

        Assert.assertEquals(5, nailingPlanks.solution(A, B, C));

    }

    @org.junit.Test
    public void shouldReturnNumberOfNailsToCoverPlanks2() {

        NailingPlanks nailingPlanks = new NailingPlanks();

        int[] A = new int[]{1};
        int[] B = new int[]{4};
        int[] C = new int[]{4, 6, 7, 10, 2};

        Assert.assertEquals(1, nailingPlanks.solution(A, B, C));

    }

    @org.junit.Test
    public void shouldReturnNumberOfNailsToCoverPlanks3() {

        NailingPlanks nailingPlanks = new NailingPlanks();

        int[] A = new int[]{1};
        int[] B = new int[]{4};
        int[] C = new int[]{5, 4, 4, 4, 4};

        Assert.assertEquals(2, nailingPlanks.solution(A, B, C));

    }

    @org.junit.Test
    public void shouldReturnNumberOfNailsToCoverPlanks4() {

        NailingPlanks nailingPlanks = new NailingPlanks();

        int[] A = new int[]{1};
        int[] B = new int[]{4};
        int[] C = new int[]{2, 2, 4, 4, 4};

        Assert.assertEquals(1, nailingPlanks.solution(A, B, C));

    }

    @org.junit.Test
    public void shouldReturnMinusOneWhenNailsDontCoverPlanks() {

        NailingPlanks nailingPlanks = new NailingPlanks();

        int[] A = new int[]{1, 4, 5, 8};
        int[] B = new int[]{4, 5, 9, 10};
        int[] C = new int[]{4, 6, 7, 2, 1};

        Assert.assertEquals(-1, nailingPlanks.solution(A, B, C));

    }

}