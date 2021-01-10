package com.krzysztofziomek.linkedlist;

import com.krzysztofziomek.structures.LinkedList;

/**
 * @author Krzysztof Ziomek
 * @since 10/01/2021.
 * <p>
 * How to find middle element of linked list in a single pass
 * https://javarevisited.blogspot.com/2012/12/how-to-find-middle-element-of-linked-list-one-pass.html#axzz6jA2IlRMn
 */
public class MiddleElementFinder {

    public LinkedList.Node find(LinkedList list) {
        if (list.head() == null) {
            return null;
        }
        LinkedList.Node current = list.head(),
            middle = current;

        while (current.next() != null) {
            current = current.next();
            if (current.next() != null) {
                current = current.next();
                middle = middle.next();
            }
        }
        return middle;
    }
}