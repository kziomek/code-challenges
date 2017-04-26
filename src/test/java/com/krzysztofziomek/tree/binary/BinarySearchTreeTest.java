package com.krzysztofziomek.tree.binary;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 26/04/2017.
 */
public class BinarySearchTreeTest {

    @Test
    public void insert5_3_2() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(5));
        tree.insert(new Node(3));
        tree.insert(new Node(2));

        Assert.assertEquals(new Integer(5), tree.getRoot().getKey());
        Assert.assertEquals(new Integer(3), tree.getRoot().getLeft().getKey());
        Assert.assertEquals(new Integer(2), tree.getRoot().getLeft().getLeft().getKey());

    }

    @Test
    public void insert() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(5));
        tree.insert(new Node(3));
        tree.insert(new Node(7));
        tree.insert(new Node(2));
        tree.insert(new Node(5));
        tree.insert(new Node(8));
//        tree.print();
        Assert.assertEquals(new Integer(2), tree.getRoot().getLeft().getLeft().getKey());
        Assert.assertEquals(new Integer(5), tree.getRoot().getRight().getLeft().getKey());
        Assert.assertEquals(new Integer(8), tree.getRoot().getRight().getRight().getKey());

    }

    @Test
    public void insert2() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(2));
        tree.insert(new Node(3));
        tree.insert(new Node(7));
        tree.insert(new Node(5));
        tree.insert(new Node(8));
        tree.insert(new Node(5));
//        tree.print();
        Assert.assertEquals(new Integer(5), tree.getRoot().getRight().getRight().getLeft().getRight().getKey());
        Assert.assertEquals(new Integer(8), tree.getRoot().getRight().getRight().getRight().getKey());

    }

}