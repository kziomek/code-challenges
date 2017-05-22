package com.krzysztofziomek.structures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Krzysztof Ziomek
 * @since 22/05/2017.
 */


public class Graph {
    private HashMap<Integer, Node> nodeLookup = new HashMap<>();

    private Node getNode(int id) {
        return nodeLookup.get(id);
    }

    public void addNode(int id) {
        nodeLookup.put(id, new Node(id));
    }

    public void addEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    public boolean hasPathDFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node node, Node destination, HashSet<Integer> visited) {
        if (visited.contains(node.id)) {
            return false;
        }
        visited.add(node.id);
        if (node == destination) {
            return true;
        }
        for (Node adjNode : node.adjacent) {
            if (hasPathDFS(adjNode, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBFS(int source, int destination) {
        return hasPathBFS(getNode(source), getNode(destination));
    }

    private boolean hasPathBFS(Node source, Node destination) {
        LinkedList<Node> nodesToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        nodesToVisit.add(source);

        while (!nodesToVisit.isEmpty()) {
            Node node = nodesToVisit.remove();
            if (visited.contains(node.id)) {
                continue;
            }
            visited.add(node.id);
            if (node == destination) {
                return true;
            }
            for (Node adjNode : node.adjacent) {
                nodesToVisit.add(adjNode);
            }
        }
        return false;

    }

    public static class Node {
        LinkedList<Node> adjacent = new LinkedList<>();
        private int id;

        private Node(int id) {
            this.id = id;
        }
    }

}
