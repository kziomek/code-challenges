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

    @Test
    public void treeSearch() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(15));
        tree.insert(new Node(6));
        tree.insert(new Node(18));
        tree.insert(new Node(3));
        tree.insert(new Node(7));
        tree.insert(new Node(17));
        tree.insert(new Node(20));
        tree.insert(new Node(2));
        tree.insert(new Node(4));
        tree.insert(new Node(13));
        tree.insert(new Node(9));
//        tree.print();

        Node node = tree.treeSearch(13);

        Assert.assertEquals(new Integer(13), node.getKey());
    }

    @Test
    public void iterativeTreeSearch() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(15));
        tree.insert(new Node(6));
        tree.insert(new Node(18));
        tree.insert(new Node(3));
        tree.insert(new Node(7));
        tree.insert(new Node(17));
        tree.insert(new Node(20));
        tree.insert(new Node(2));
        tree.insert(new Node(4));
        tree.insert(new Node(13));
        tree.insert(new Node(9));
//        tree.print();

        Node node = tree.iterativeTreeSearch(tree.getRoot(), 13);

        Assert.assertEquals(new Integer(13), node.getKey());
    }

    @Test
    public void treeMinimum() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(15));
        tree.insert(new Node(6));
        tree.insert(new Node(18));
        tree.insert(new Node(3));
        tree.insert(new Node(7));
        tree.insert(new Node(17));
        tree.insert(new Node(20));
        tree.insert(new Node(2));
        tree.insert(new Node(4));
        tree.insert(new Node(13));
        tree.insert(new Node(9));

        Assert.assertEquals(new Integer(2), tree.minimum().getKey());
    }

    @Test
    public void treeMaximum() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(15));
        tree.insert(new Node(6));
        tree.insert(new Node(18));
        tree.insert(new Node(3));
        tree.insert(new Node(7));
        tree.insert(new Node(17));
        tree.insert(new Node(20));
        tree.insert(new Node(2));
        tree.insert(new Node(4));
        tree.insert(new Node(13));
        tree.insert(new Node(9));

        Assert.assertEquals(20, tree.maximum());
    }

    @Test
    public void succesorOf13() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(15));
        tree.insert(new Node(6));
        tree.insert(new Node(18));
        tree.insert(new Node(3));
        tree.insert(new Node(7));
        tree.insert(new Node(17));
        tree.insert(new Node(20));
        tree.insert(new Node(2));
        tree.insert(new Node(4));
        tree.insert(new Node(13));
        tree.insert(new Node(9));

        Node node13 = tree.treeSearch(13);

        Assert.assertEquals(new Integer(15), tree.successor(node13).getKey());
    }

    @Test
    public void treeDeleteNodeWithoutChildren() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(15));
        tree.insert(new Node(5));
        tree.insert(new Node(16));
        tree.insert(new Node(3));
        tree.insert(new Node(12));
        tree.insert(new Node(20));
        tree.insert(new Node(10));
        tree.insert(new Node(13));
        tree.insert(new Node(18));
        tree.insert(new Node(23));
        tree.insert(new Node(6));
        tree.insert(new Node(7));

        Assert.assertEquals(new Integer(13), tree.getRoot().getLeft().getRight().getRight().getKey());

        tree.delete(13);

        Assert.assertNull(tree.getRoot().getLeft().getRight().getRight());

    }

    @Test
    public void treeDeleteNodeWithOneChildren() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(15));
        tree.insert(new Node(5));
        tree.insert(new Node(16));
        tree.insert(new Node(3));
        tree.insert(new Node(12));
        tree.insert(new Node(20));
        tree.insert(new Node(10));
        tree.insert(new Node(13));
        tree.insert(new Node(18));
        tree.insert(new Node(23));
        tree.insert(new Node(6));
        tree.insert(new Node(7));

        Assert.assertEquals(new Integer(16), tree.getRoot().getRight().getKey());

        tree.delete(16);

        Assert.assertEquals(new Integer(20), tree.getRoot().getRight().getKey());

    }

    @Test
    public void treeDeleteNodeWithTwoChildrens() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(15));
        tree.insert(new Node(5));
        tree.insert(new Node(16));
        tree.insert(new Node(3));
        tree.insert(new Node(12));
        tree.insert(new Node(20));
        tree.insert(new Node(10));
        tree.insert(new Node(13));
        tree.insert(new Node(18));
        tree.insert(new Node(23));
        tree.insert(new Node(6));
        tree.insert(new Node(7));

        Assert.assertEquals(new Integer(5), tree.getRoot().getLeft().getKey());

        tree.delete(5);

        Assert.assertEquals(new Integer(6), tree.getRoot().getLeft().getKey());

    }

}