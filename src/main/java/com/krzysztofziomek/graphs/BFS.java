package com.krzysztofziomek.graphs;

import java.util.*;

/**
 * @author Krzysztof Ziomek
 * @since 14/02/2021.
 * <p>
 * Breadth First Search or BFS for a Graph
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 */
public class BFS {

    public List<String> bfsTraversal(String vertex, Map<String, List<String>> graph) {
        List<String> traversal = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(vertex);

        while (!queue.isEmpty()) {
            String v = queue.poll();
            System.out.println(v + " ");
            traversal.add(v);
            visited.add(v);

            for (String adj : graph.get(v)) {
                if (!visited.contains(adj)) {
                    visited.add(adj);
                    queue.add(adj);
                }
            }
        }
        return traversal;
    }
}