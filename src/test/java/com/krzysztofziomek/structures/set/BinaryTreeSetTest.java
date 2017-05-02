package com.krzysztofziomek.structures.set;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Krzysztof Ziomek
 * @since 01/05/2017.
 */
public class BinaryTreeSetTest {

    @Test
    public void testBuildingTree() {

        /* Empty */
        BinaryTreeSet<Integer> set = new BinaryTreeSet<>();
        assertTrue(set.isEmpty());

        /* Root */
        set.add(5);
        assertEquals(new Integer(5), set.getRoot().getElement());

        set.add(2);
        assertEquals(new Integer(2), set.getRoot().getLeft().getElement());

        set.add(7);
        assertEquals(new Integer(7), set.getRoot().getRight().getElement());

        set.add(1);
        assertEquals(new Integer(1), set.getRoot().getLeft().getLeft().getElement());

        set.add(4);
        assertEquals(new Integer(4), set.getRoot().getLeft().getRight().getElement());

        set.add(10);
        assertEquals(new Integer(10), set.getRoot().getRight().getRight().getElement());

        set.add(7);
        set.add(5);

        // * Parent -> Leaf -> Parent */
        assertEquals(new Integer(5), set.getRoot().getRight().getRight().getParent().getParent().getElement());

        set.print();
    }

    /* Delete node which has no children */

    @Test
    public void deleteRoot() {
        BinaryTreeSet<Integer> set = new BinaryTreeSet<>();
        set.add(15);

        assertTrue(set.contains(15));
        assertTrue(set.remove(15));
        assertFalse(set.contains(15));
        assertNull(set.getRoot());

    }

    @Test
    public void testDeleteRightNodeWithoutChildern() {
        BinaryTreeSet<Integer> set = buildTreeForDeleteTests();
        set.print();

        assertTrue(set.contains(13));
        assertTrue(set.remove(13));
        assertFalse(set.contains(13));

    }

    @Test
    public void testDeleteLeftNodeWithoutChildern() {
        BinaryTreeSet<Integer> set = buildTreeForDeleteTests();
        set.print();

        assertTrue(set.contains(18));
        assertTrue(set.remove(18));
        assertFalse(set.contains(18));

    }

    /* Delete node which has one children */

    @Test
    public void deleteRootWithLeftChild() {
        BinaryTreeSet<Integer> set = new BinaryTreeSet<>();
        set.add(15);
        set.add(5);

        assertTrue(set.contains(15));
        assertTrue(set.remove(15));
        assertFalse(set.contains(15));
        assertEquals(new Integer(5), set.getRoot().getElement());

    }

    @Test
    public void deleteRootWithRightChild() {
        BinaryTreeSet<Integer> set = new BinaryTreeSet<>();
        set.add(15);
        set.add(16);

        assertTrue(set.contains(15));
        assertTrue(set.remove(15));
        assertFalse(set.contains(15));
        assertEquals(new Integer(16), set.getRoot().getElement());

    }

    @Test
    public void deleteRightNodeWithRightChild() {
        BinaryTreeSet<Integer> set = buildTreeForDeleteTests();
        set.print();

        assertTrue(set.contains(16));
        assertTrue(set.remove(16));
        assertFalse(set.contains(16));
        assertEquals(new Integer(20), set.getRoot().getRight().getElement());
    }

    @Test
    public void deleteRightNodeWithLeftChild() {
        BinaryTreeSet<Integer> set = buildTreeForDeleteTests();
        set.print();

        assertTrue(set.contains(23));
        assertTrue(set.remove(23));
        assertFalse(set.contains(23));
        assertEquals(new Integer(22), set.getRoot().getRight().getRight().getRight().getElement());

    }

    @Test
    public void deleteLeftNodeWithRightChild() {
        BinaryTreeSet<Integer> set = buildTreeForDeleteTests();
        set.print();

        assertTrue(set.contains(6));
        assertTrue(set.remove(6));
        assertFalse(set.contains(6));
        assertEquals(new Integer(7), set.getRoot().getLeft().getRight().getLeft().getLeft().getElement());
    }

    @Test
    public void deleteLeftNodeWithLeftChild() {
        BinaryTreeSet<Integer> set = buildTreeForDeleteTests();
        set.print();

        assertTrue(set.contains(10));
        assertTrue(set.remove(10));
        assertFalse(set.contains(10));
        assertEquals(new Integer(6), set.getRoot().getLeft().getRight().getLeft().getElement());
    }

    @Test
    public void deleteLeftNodeWithTwoChildren() {
        //TODO
    }

    @Test
    public void deleteRightNodeWithTwoChildren() {
        //TODO
    }

    private BinaryTreeSet<Integer> buildTreeForDeleteTests() {
        BinaryTreeSet<Integer> set = new BinaryTreeSet<>();
        set.add(15);
        set.add(5);
        set.add(16);
        set.add(3);
        set.add(12);
        set.add(20);
        set.add(10);
        set.add(13);
        set.add(18);
        set.add(23);
        set.add(6);
        set.add(7);
        set.add(22);
        return set;
    }


}