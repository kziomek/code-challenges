package com.krzysztofziomek.graphs;

import java.util.*;

/**
 * @author Krzysztof Ziomek
 * @since 14/02/2021.
 * <p>
 * Recursive Depth First Search or DFS for a Graph
 * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 */
public class DFSRecursive {

    public List<String> runDFS(String v, Map<String, List<String>> graph) {
        List<String> traversal = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        dfsRecursive(v, graph, visited, traversal);
        return traversal;
    }

    public void dfsRecursive(String v, Map<String, List<String>> graph, Set<String> visited, List<String> traversal) {
        System.out.println(v);
        traversal.add(v);
        visited.add(v);

        for (String adj : graph.get(v)) {
            if (!visited.contains(adj)) {
                dfsRecursive(adj, graph, visited, traversal);
            }
        }
    }
}
