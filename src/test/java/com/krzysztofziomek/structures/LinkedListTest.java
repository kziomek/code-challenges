package com.krzysztofziomek.structures;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 10/01/2021.
 */
public class LinkedListTest {

    @Test
    public void addFirstNodeToList() {
        LinkedList l = new LinkedList();
        l.add(new LinkedList.Node("A"));
        Assert.assertEquals("A", l.head().data());
    }

    @Test
    public void addThreeNodesToList() {
        LinkedList l = new LinkedList();
        l.add(new LinkedList.Node("A"));
        l.add(new LinkedList.Node("B"));
        l.add(new LinkedList.Node("C"));

        Assert.assertEquals("A", l.head().data());
        Assert.assertEquals("B", l.head().next().data());
        Assert.assertEquals("C", l.head().next().next().data());
    }
}