package com.krzysztofziomek.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Krzysztof Ziomek
 * @since 30/01/2021.
 */
public class LowestCommonAncestor {

    public Node lcaDFS(Node root, String v1, String v2) {
        Deque<Node> n1Path = findPath(new LinkedList<>(), root, v1);
        Deque<Node> n2Path = findPath(new LinkedList<>(), root, v2);

        Node result = null;
        if (n1Path == null || n2Path == null) {
            return null;
        }
        while (n1Path.peek() != null && n2Path.peek() != null
            && n1Path.peek().value.equals(n2Path.peek().value)) {
            result = n1Path.poll();
            n2Path.poll();
        }
        return result;
    }

    public Deque<Node> findPath(Deque<Node> queue, Node node, String value) {
        queue.add(node);
        if (node.value.equals(value)) {
            return queue;
        }
        for (Node n : node.getDescendants()) {
            if (findPath(queue, n, value) != null) {
                return queue;
            } else {
                queue.removeLast();
            }
        }
        return null;
    }


    // solution with one traversal, assumes both node exist in the tree
    public Node lca(Node node, String v1, String v2) {
        if (node == null) {
            return null;
        }
        if (node.value.equals(v1) || node.value.equals(v2)) {
            return node;
        }

        Node node1 = null;
        Node node2 = null;
        for (Node n : node.getDescendants()) {
            Node res = lca(n, v1, v2);
            if (res != null) {
                if (node1 == null) {
                    node1 = res;
                } else {
                    node2 = res;
                }
            }
        }

        if (node1 == null) {
            return null;
        }

        return (node2 != null) ? node : node1;
    }

    public static class Node {
        private final String value;
        private final List<Node> descendants = new LinkedList<>();

        public Node(String value) {
            this.value = value;
        }

        public void add(Node n) {
            descendants.add(n);
        }

        public List<Node> getDescendants() {
            return descendants;
        }

        public String getValue() {
            return value;
        }
    }
}