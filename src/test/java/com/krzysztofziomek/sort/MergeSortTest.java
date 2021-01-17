package com.krzysztofziomek.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 16/01/2021.
 */
public class MergeSortTest {

    @Test
    public void testEvenArray() {
        int[] A = {2, 4, 1, 6, 8, 5, 3, 7};
        new MergeSort().mergeSort(A, 0, A.length - 1);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, A);
    }

    @Test
    public void testOddArray() {
        int[] A = {3, 4, 2, 5, 1};
        new MergeSort().mergeSort(A, 0, A.length - 1);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, A);
    }
}