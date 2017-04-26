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


}
