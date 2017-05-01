package com.krzysztofziomek.structures.set;

/**
 * @author Krzysztof Ziomek
 * @since 01/05/2017.
 */
public class Node<E extends Comparable<E>> {

    private E element;

    private Node<E> parent;

    private Node<E> left;
    private Node<E> right;

    public Node(E e) {
        element = e;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getParent() {
        return parent;
    }

    public Node<E> getLeft() {
        return left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }
}
