package com.krzysztofziomek.graphs;


import java.util.*;

/**
 *  Water Supply
 *  https://www.geeksforgeeks.org/implementing-water-supply-problem-using-breadth-first-search/?ref=rp
 */
public class WaterSupply {

    public static int max(Map<Integer, List<Integer>> graph, Set<Integer> blocked) {
        int maxSupply = 0;

        for (Integer vertx : graph.keySet()) {
            int countSupply = bfsCountSupply(vertx, graph, blocked);
            maxSupply = Math.max(maxSupply, countSupply);
        }

        return maxSupply;
    }

    public static int bfsCountSupply(Integer sv, Map<Integer, List<Integer>> graph, Set<Integer> blocked) {
        int count = 0;
        Set<Integer> viewed = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(sv);
        viewed.add(sv);

        while (!queue.isEmpty()) {
            Integer cv = queue.removeFirst();
            count++;
            if (!blocked.contains(cv)) {
                for (Integer v : graph.get(cv)) {
                    if (!viewed.contains(v)) {
                        queue.add(v);
                        viewed.add(v);
                    }
                }
            }
        }
        return count;
    }
}