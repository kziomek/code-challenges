package com.krzysztofziomek.structures.set;

/**
 * @author Krzysztof Ziomek
 * @since 28/04/2017.
 */
public class ArrayBasedSet<E> implements MySet<E> {

    private E elements[];
    private int size = 0;

    private static final int INCREMENT = 5;


    @SuppressWarnings("unchecked")
    public ArrayBasedSet() {
        elements = (E[]) new Object[INCREMENT];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E elem) {
        if (elem == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elem.equals(elements[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void add(E element) {
        if (!contains(element)) {
            if (size == elements.length) {
                incrementArray();
            }
            elements[size++] = element;
        }
    }

    public boolean remove(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    shiftElements(i);
                    size--;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    shiftElements(i);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    private void shiftElements(int start) {
        System.arraycopy(elements, start + 1, elements, start, size - start - 1);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(elements[i]);
            if (i + 1 < size) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    @SuppressWarnings("unchecked")
    private void incrementArray() {
        E[] temparray = elements;
        int tempsize = size + INCREMENT;
        elements = (E[]) new Object[tempsize];
        System.arraycopy(temparray, 0, elements, 0, size);
    }


}
