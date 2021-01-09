package com.krzysztofziomek.codility.counting;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 09/01/2021.
 */
public class MissingIntegerTest {

    @Test
    public void test() {
        Assert.assertEquals(5, new MissingInteger().solution(new int[]{1, 3, 6, 4, 1, 2}));
        Assert.assertEquals(4, new MissingInteger().solution(new int[]{1, 2, 3}));
        Assert.assertEquals(1, new MissingInteger().solution(new int[]{-1, -3}));
    }
}