package com.krzysztofziomek.dynamic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 24/01/2021.
 */
public class LongestIncreasingSubsequenceTest {

    @Test
    public void recTest() {
        int[] a = {3, 10, 2, 1, 20};
        Assert.assertEquals(3, new LongestIncreasingSubsequence().recLis(a));
    }

    @Test
    public void recTest2() {
        int[] a = {3, 10, 2, 1, 20, 5};
        Assert.assertEquals(3, new LongestIncreasingSubsequence().recLis(a));
    }

    @Test
    public void recTest3() {
        int[] a = {3, 2};
        Assert.assertEquals(1, new LongestIncreasingSubsequence().recLis(a));
    }

    @Test
    public void recTest4() {
        int[] a = {50, 3, 10, 7, 40, 80};
        Assert.assertEquals(4, new LongestIncreasingSubsequence().recLis(a));
    }

    @Test
    public void recTest5() {
        int[] a = {10, 22, 9, 33, 21, 50, 41, 60};
        Assert.assertEquals(5, new LongestIncreasingSubsequence().recLis(a));
    }

    @Test
    public void dpTest() {
        int[] a = {3, 10, 2, 1, 20};
        Assert.assertEquals(3, new LongestIncreasingSubsequence().dpLis(a));
    }

    @Test
    public void dpTest2() {
        int[] a = {3, 10, 2, 1, 20, 5};
        Assert.assertEquals(3, new LongestIncreasingSubsequence().dpLis(a));
    }

    @Test
    public void dpTest3() {
        int[] a = {3, 2};
        Assert.assertEquals(1, new LongestIncreasingSubsequence().dpLis(a));
    }

    @Test
    public void dpTtest4() {
        int[] a = {50, 3, 10, 7, 40, 80};
        Assert.assertEquals(4, new LongestIncreasingSubsequence().dpLis(a));
    }

    @Test
    public void dpTtest5() {
        int[] a = {10, 22, 9, 33, 21, 50, 41, 60};
        ;
        Assert.assertEquals(5, new LongestIncreasingSubsequence().dpLis(a));
    }
}