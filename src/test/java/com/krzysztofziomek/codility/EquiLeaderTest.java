package com.krzysztofziomek.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Krzysztof Ziomek
 * @since 30/04/2017.
 */
public class EquiLeaderTest {

    @Test
    public void solution() throws Exception {

        assertEquals(1, new EquiLeader().solution(new int[]{1, 1}));
        assertEquals(2, new EquiLeader().solution(new int[]{1, 1, 1}));
        assertEquals(3, new EquiLeader().solution(new int[]{1, 1, 1, 1}));
        assertEquals(0, new EquiLeader().solution(new int[]{1, 2}));
        assertEquals(0, new EquiLeader().solution(new int[]{1, 2, 1, 2, 1}));
        assertEquals(4, new EquiLeader().solution(new int[]{1, 1, 2, 1, 1}));
        assertEquals(2, new EquiLeader().solution(new int[]{4, 3, 4, 4, 4, 2}));

    }

}