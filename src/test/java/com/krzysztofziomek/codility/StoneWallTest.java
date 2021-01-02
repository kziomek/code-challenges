package com.krzysztofziomek.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Krzysztof Ziomek
 * @since 02/01/2021.
 */
public class StoneWallTest {

    @Test
    public void test() {
        StoneWall sw = new StoneWall();
        assertEquals(7, sw.solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));
    }
}