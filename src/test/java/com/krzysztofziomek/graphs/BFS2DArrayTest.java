package com.krzysztofziomek.graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 20/02/2021.
 */
public class BFS2DArrayTest {

    @Test
    public void testTraversal() {
        int[][] grid = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}};
        Integer[] result = new BFS2DArray().traverse(grid);

        Assert.assertArrayEquals(new Integer[]{1, 2, 5, 3, 6, 9, 4, 7, 10, 13, 8, 11, 14, 12, 15, 16}, result);
    }
}