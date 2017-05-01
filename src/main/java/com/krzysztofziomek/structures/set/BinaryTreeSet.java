package com.krzysztofziomek.structures.set;

/**
 * @author Krzysztof Ziomek
 * @since 01/05/2017.
 */
public class BinaryTreeSet<E extends Comparable<E>> implements MySet<E> {

    private Node<E> root;

    @Override
    public int size() {
        return 0;
    }

    public Node<E> getRoot() {
        return root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(E elem) {
        return contains(root, elem);
    }

    private boolean contains(Node<E> parent, E elem) {
        if (parent == null) {
            return false;
        } else if (parent.getElement().compareTo(elem) == 0) {
            return true;
        } else {
            return contains(parent.getLeft(), elem) || contains(parent.getRight(), elem);
        }
    }

    @Override
    public void add(E element) {
        if (contains(element)) {
            return;
        }

        Node<E> node = new Node<>(element);
        if (root == null) {
            root = node;
        } else {
            add(root, node);
        }

    }

    public void add(Node<E> parent, Node<E> node) {

        if (node.getElement().compareTo(parent.getElement()) < 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(node);
                node.setParent(parent);
            } else {
                add(parent.getLeft(), node);
            }
        } else {
            if (parent.getRight() == null) {
                parent.setRight(node);
                node.setParent(parent);
            } else {
                add(parent.getRight(), node);
            }
        }

    }

    @Override
    public boolean remove(E element) {

        // TODO
        return false;
    }


    public void print() {
        if (root != null) {
            print(root);
        }
    }

    private void print(Node<E> node) {
        if (node.getRight() != null) {
            print(node.getRight());
        }

        printElement(node);

        if (node.getLeft() != null) {
            print(node.getLeft());
        }

    }

    private void printElement(Node<E> node) {
        Node p = node.getParent();
        while (p != null) {
            System.out.print(" ");
            p = p.getParent();
        }
        System.out.println(node.getElement());
    }
}
