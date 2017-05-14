package com.krzysztofziomek.codility;

import org.junit.Assert;

/**
 * @author Krzysztof Ziomek
 * @since 14/05/2017.
 */
public class FibFrogTest {

    @org.junit.Test
    public void solution() throws Exception {
        FibFrog fibFrog = new FibFrog();
        Assert.assertEquals(3, fibFrog.solution(new int[]{0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0}));

        Assert.assertEquals(2, fibFrog.solution(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0}));

        Assert.assertEquals(-1, fibFrog.solution(new int[]{0,0,0}));
    }

}