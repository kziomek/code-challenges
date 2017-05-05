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
        Node<E> node = search(element);
        if (node == null) {
            return false;
        }

        if (node.getLeft() == null && node.getRight() == null) { // Node has no children
            if (node.getParent() == null) {
                root = null;
                return true;
            } else {
                if (node.getElement().equals(node.getParent().getLeft().getElement())) {
                    node.getParent().setLeft(null);
                    return true;
                } else {
                    node.getParent().setRight(null);
                    return true;
                }
            }
        } else if (node.getLeft() != null && node.getRight() != null) { // Node has 2 children
            if (node == root) {
                root = node.getRight();
                root.setParent(null);
                root.setLeft(node.getLeft());
                node.getLeft().setParent(root);
                return true;
            } else {
                Node<E> successor = findSuccesor(node);
                if (successor.getRight() != null) {
                    successor.getRight().setParent(successor.getParent());
                }
                successor.getParent().setLeft(successor.getRight());
                node.setElement(successor.getElement());
                return true;
            }

        } else { // Node has 1 child
            Node<E> child;
            if (node.getLeft() != null) {
                child = node.getLeft();
            } else {
                child = node.getRight();
            }

            if (node.getParent() == null) { //root
                child.setParent(null);
                root = child;
                return true;
            } else {
                if (node.getElement().equals(node.getParent().getLeft().getElement())) { //node is on left side
                    node.getParent().setLeft(child);
                    child.setParent(node.getParent());
                    return true;
                } else { //node is on right side
                    node.getParent().setRight(child);
                    child.setParent(node.getParent());
                    return true;
                }
            }
        }
    }

    public Node<E> search(E element) {
        return search(root, element);
    }

    private Node<E> findSuccesor(Node<E> x) {
        if (x.getRight() != null) {
            return findMinimum(x.getRight());
        }
        Node<E> s = x.getParent();
        while (s != null && x == s.getRight()) {
            x = s;
            s = s.getParent();
        }
        return s;

    }

    private Node<E> findMinimum(Node<E> node) {
        Node<E> min = node;
        while (min.getLeft() != null) {
            min = min.getLeft();
        }
        return min;
    }

    private Node<E> search(Node<E> node, E element) {
        if (node == null || node.getElement().compareTo(element) == 0) {
            return node;
        }
        if (node.getElement().compareTo(element) > 0) {
            return search(node.getLeft(), element);
        } else {
            return search(node.getRight(), element);
        }
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
            System.out.print("  ");
            p = p.getParent();
        }
        System.out.println(node.getElement());
    }
}
