package com.krzysztofziomek.codility.prefixsum;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 20/05/2017.
 */
public class CountDivTest {
    @Test
    public void solution() throws Exception {
        CountDiv countDiv = new CountDiv();
        Assert.assertEquals(1, countDiv.solution(0,1,2));
        Assert.assertEquals(2, countDiv.solution(0,3,2));
        Assert.assertEquals(3, countDiv.solution(0,4,2));
        Assert.assertEquals(2, countDiv.solution(4,11,5));
        Assert.assertEquals(2, countDiv.solution(5,11,5));
    }

}