package com.krzysztofziomek.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Krzysztof Ziomek
 * @since 04/05/2017.
 */
public class DistinctTest {
    @Test
    public void solution() throws Exception {

        assertEquals(3, new Distinct().solution(new int[]{2, 1, 1, 2, 3, 1}));

        assertEquals(0, new Distinct().solution(new int[]{}));

    }

}