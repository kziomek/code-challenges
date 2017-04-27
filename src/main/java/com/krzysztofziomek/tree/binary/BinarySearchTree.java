package com.krzysztofziomek.tree.binary;

/**
 * @author Krzysztof Ziomek
 * @since 26/04/2017.
 */
public class BinarySearchTree {

    private Node root = null;

    public Node getRoot() {
        return root;
    }

    public void insert(Node z) {
        Node x = root;
        Node y = null;
        while (x != null) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        z.setParent(y);
        if (y == null) {
            root = z;
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }

    }

    public Node treeSearch(int k) {
        return treeSearch(root, k);
    }

    private Node treeSearch(Node x, int k) {
        if (x == null || x.getKey() == k) {
            return x;
        }
        if (k < x.getKey()) {
            return treeSearch(x.getLeft(), k);
        } else {
            return treeSearch(x.getRight(), k);
        }
    }

    public Node iterativeTreeSearch(Node x, int k) {
        while (x != null && x.getKey() != k) {
            if (k < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        return x;
    }

    public void print() {
        Node x = root;
        inorderTreeWalk(x);
    }

    private void inorderTreeWalk(Node x) {
        if (x != null) {
            inorderTreeWalk(x.getLeft());
            x.print();
            inorderTreeWalk(x.getRight());
        }
    }


    public Node minimum() {
        return minimum(root);
    }

    private Node minimum(Node x) {
        while (x.getLeft() != null) {
            x = x.getLeft();
        }
        return x;
    }

    public int maximum() {
        Node x = root;
        while (x.getRight() != null) {
            x = x.getRight();
        }
        return x.getKey();
    }

    public Node successor(Node x) {
        if (x.getRight() != null) {
            return minimum(x.getRight());
        }
        Node y = x.getParent();
        while (y != null && x.getKey().equals(y.getRight().getKey())) {
            x = y;
            y = y.getParent();
        }
        return y;
    }

    public void delete(int key) {
        Node z = treeSearch(key);
        Node y;
        Node x;

        if (z.getLeft() == null || z.getRight() == null) {
            y = z;
        } else {
            y = successor(z);
        }

        if (y.getLeft() != null) {
            x = y.getLeft();
        } else {
            x = y.getRight();
        }

        if (x != null) {
            x.setParent(y.getParent());
        }

        if (y.getParent() == null) {
            root = x;
        } else if (y == y.getParent().getLeft()) {
            y.getParent().setLeft(x);
        } else {
            y.getParent().setRight(x);
        }

        if (y != z) {
            z.setKey(y.getKey());
        }

    }
}
