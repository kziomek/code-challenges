package com.krzysztofziomek.codility.prefixsum;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 20/05/2017.
 */
public class PassingCarsTest {

    @Test
    public void solution() throws Exception {
        Assert.assertEquals(5, new PassingCars().solution(new int[]{0, 1, 0, 1, 1}));
        Assert.assertEquals(4, new PassingCars().solution(new int[]{1, 0, 0, 1, 1}));
    }

}