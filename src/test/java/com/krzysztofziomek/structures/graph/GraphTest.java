package com.krzysztofziomek.structures.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 22/05/2017.
 */
public class GraphTest {


    private Graph buildConsistentGraph() {
        Graph graph = new Graph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.addNode(7);
        graph.addNode(8);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 6);

        graph.addEdge(2, 3);
        graph.addEdge(3, 6);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        graph.addEdge(6, 8);
        graph.addEdge(7, 8);
        return graph;
    }

    private Graph buildSplitedGraph() {
        Graph graph = new Graph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.addNode(7);
        graph.addNode(8);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 6);

        graph.addEdge(2, 3);
        graph.addEdge(3, 6);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        //removed 6->8 edge
        graph.addEdge(7, 8);
        return graph;
    }

    @Test
    public void hasPathDFSShouldReturnTrueWhenPathExistsBetweenSourceAndDestination() throws Exception {
        Graph graph = buildConsistentGraph();
        Assert.assertTrue(graph.hasPathDFS(1, 8));
    }

    @Test
    public void hasPathBFSShouldReturnTrueWhenPathExistsBetweenSourceAndDestination() throws Exception {
        Graph graph = buildConsistentGraph();
        Assert.assertTrue(graph.hasPathBFS(1, 8));
    }

    @Test
    public void hasPathDFSShouldReturnFalseWhenNoPathBetweenSourceAndDestination() throws Exception {
        Graph graph = buildSplitedGraph();
        Assert.assertFalse(graph.hasPathDFS(1, 8));
    }

    @Test
    public void hasPathBFSShouldReturnFalseWhenNoPathBetweenSourceAndDestination() throws Exception {
        Graph graph = buildSplitedGraph();
        Assert.assertFalse(graph.hasPathBFS(1, 8));
    }

}