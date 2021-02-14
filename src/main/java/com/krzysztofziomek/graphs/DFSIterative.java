package com.krzysztofziomek.graphs;

import java.util.*;

/**
 * @author Krzysztof Ziomek
 * @since 14/02/2021.
 * <p>
 * Iterative Depth First Traversal of Graph
 * https://www.geeksforgeeks.org/iterative-depth-first-traversal/
 */
public class DFSIterative {

    public List<String> dfsIterative(String startVertx, Map<String, List<String>> graph) {
        List<String> traversal = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.add(startVertx);

        while (!stack.isEmpty()) {
            String v = stack.pop();
            if (!visited.contains(v)) {
                System.out.println(v);
                traversal.add(v);
                visited.add(v);
            }

            for (String adj : graph.get(v)) {
                if (!visited.contains(adj)) {
                    stack.add(adj);
                }
            }

        }
        return traversal;
    }
}