package com.krzysztofziomek.structures.set;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Krzysztof Ziomek
 * @since 01/05/2017.
 */
public class BinaryTreeSetTest {

    @Test
    public void test() {

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

}