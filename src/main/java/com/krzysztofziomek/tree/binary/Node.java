package com.krzysztofziomek.tree.binary;

/**
 * @author Krzysztof Ziomek
 * @since 26/04/2017.
 */
public class Node {

    private Node parent;

    private Node left;
    private Node right;

    private Integer key;

    public Node(int i) {
        key = i;
    }


    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public void print() {
        System.out.println(key);

    }
}
