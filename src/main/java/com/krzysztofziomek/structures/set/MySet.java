package com.krzysztofziomek.structures.set;

/**
 * @author Krzysztof Ziomek
 * @since 01/05/2017.
 */
public interface MySet<E> {

    int size();

    boolean isEmpty();

    boolean contains(E elem);

    void add(E element);

    boolean remove(E element);

    String toString();

}
