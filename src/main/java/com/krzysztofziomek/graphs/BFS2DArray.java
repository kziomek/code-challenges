package com.krzysztofziomek.graphs;


import java.util.*;

/**
 * @author Krzysztof Ziomek
 * @since 20/02/2021.
 * <p>
 * https://www.geeksforgeeks.org/breadth-first-traversal-bfs-on-a-2d-array/?ref=rp
 */
public class BFS2DArray {

    private boolean isValid(boolean[][] vis, int row, int col) {
        return row < vis.length && col < vis[0].length && !vis[row][col];
    }

    public Integer[] traverse(int[][] grid) {
        List<Integer> result = new LinkedList<>();

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            visited[p.row][p.col] = true;
            result.add(grid[p.row][p.col]);
            if (isValid(visited, p.row, p.col + 1)) {
                queue.add(new Pos(p.row, p.col + 1));
                visited[p.row][p.col + 1] = true;
            }
            if (isValid(visited, p.row + 1, p.col)) {
                queue.add(new Pos(p.row + 1, p.col));
                visited[p.row + 1][p.col] = true;
            }
        }
        return result.toArray(new Integer[0]);
    }

    private static class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}