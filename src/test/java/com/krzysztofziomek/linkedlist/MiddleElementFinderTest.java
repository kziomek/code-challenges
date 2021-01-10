package com.krzysztofziomek.linkedlist;

import com.krzysztofziomek.structures.LinkedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 10/01/2021.
 */
public class MiddleElementFinderTest {

    @Test
    public void findMiddleElement() {
        LinkedList list = new LinkedList();
        MiddleElementFinder middleElementFinder = new MiddleElementFinder();

        Assert.assertNull(middleElementFinder.find(list));

        list.add(new LinkedList.Node("A"));
        Assert.assertEquals("A", middleElementFinder.find(list).data());

        list.add(new LinkedList.Node("B"));
        Assert.assertEquals("A", middleElementFinder.find(list).data());

        list.add(new LinkedList.Node("C"));
        Assert.assertEquals("B", middleElementFinder.find(list).data());

        list.add(new LinkedList.Node("D"));
        Assert.assertEquals("B", middleElementFinder.find(list).data());

        list.add(new LinkedList.Node("E"));
        Assert.assertEquals("C", middleElementFinder.find(list).data());
    }
}