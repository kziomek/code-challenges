package com.krzysztofziomek.codility;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 29/04/2017.
 */
public class AbsDistinctTest {

    @Test
    public void solution() throws Exception {
        AbsDistinct absDistinct = new AbsDistinct();

        Assert.assertEquals(2, absDistinct.solution(new int[]{-2147483648, -2147483648, 1}));
        Assert.assertEquals(2, absDistinct.solution(new int[]{-3, -2}));
        Assert.assertEquals(1, absDistinct.solution(new int[]{-3, -3}));
        Assert.assertEquals(2, absDistinct.solution(new int[]{-3, -3, -2}));
        Assert.assertEquals(1, absDistinct.solution(new int[]{0, 0}));
        Assert.assertEquals(2, absDistinct.solution(new int[]{1, 2}));
        Assert.assertEquals(2, absDistinct.solution(new int[]{1, 2, 2}));
        Assert.assertEquals(5, absDistinct.solution(new int[]{-5, -3, -1, 0, 3, 6}));
        Assert.assertEquals(2, absDistinct.solution(new int[]{-2, 1}));
        Assert.assertEquals(2, absDistinct.solution(new int[]{-2,-2, -1,  2, 2}));
        Assert.assertEquals(3, absDistinct.solution(new int[]{-3, -2,-2, -1,  3, 3}));
    }

    @Test
    public void sl() {
        AbsDistinct absDistinct = new AbsDistinct();
        Assert.assertEquals(5, absDistinct.solution(new int[]{-5, -3, -1, 0, 3, 6}));

    }

}