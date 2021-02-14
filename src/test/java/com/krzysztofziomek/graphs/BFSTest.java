package com.krzysztofziomek.graphs;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Krzysztof Ziomek
 * @since 14/02/2021.
 */
public class BFSTest {

    /*
              B   D
             /   /
            A   C---E
             \ / \  |
              S   F |
               \ /  |
                G---H
     */
    @Test
    public void bfsTest() {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Lists.newArrayList("B", "S"));
        graph.put("B", Lists.newArrayList("A"));
        graph.put("C", Lists.newArrayList("D", "E", "F", "S"));
        graph.put("D", Lists.newArrayList("C"));
        graph.put("E", Lists.newArrayList("C", "H"));
        graph.put("F", Lists.newArrayList("C", "G"));
        graph.put("G", Lists.newArrayList("F", "H", "S"));
        graph.put("H", Lists.newArrayList("E", "G"));
        graph.put("S", Lists.newArrayList("A", "C", "G"));

        List<String> traversal = new BFS().bfsTraversal("A", graph);

        Assert.assertEquals(Lists.newArrayList("A", "B", "S", "C", "G", "D", "E", "F", "H"), traversal);
    }
}