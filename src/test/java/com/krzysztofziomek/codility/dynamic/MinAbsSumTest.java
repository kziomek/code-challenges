package com.krzysztofziomek.codility.dynamic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 21/05/2017.
 */
public class MinAbsSumTest {

    @Test
    public void solution() throws Exception {
        Assert.assertEquals(0,new MinAbsSum().solution(new int[]{1,5,2,-2}));

        Assert.assertEquals(0,new MinAbsSum().solution(new int[]{1,-2,-3,4,-5,7}));

        Assert.assertEquals(0,new MinAbsSum().solution(new int[]{0,0,0}));
        Assert.assertEquals(0,new MinAbsSum().solution(new int[]{3, 3, 3, 4, 5}));
        Assert.assertEquals(6,new MinAbsSum().solution(new int[]{10, 11, 12, 13, 14}));


    }

}