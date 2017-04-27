package com.krzysztofziomek.structures;

/**
 * @author Krzysztof Ziomek
 * @since 27/04/2017.
 */
public class Queue {

    private long[] Q;
    int size;
    private int head;
    private int tail;

    public Queue(int size) {
        Q = new long[size];
        head = 0;
        tail = 0;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void enqueue(long k) {
        if (size == Q.length) {
            throw new IllegalStateException("overflow");
        }
        Q[tail] = k;
        size++;
        tail = (tail + 1) % Q.length;
    }

    public long dequeue() {
        if (size == 0) {
            throw new IllegalStateException("underflow");
        }
        long key = Q[head];
        size--;
        head = (head + 1) % Q.length;
        return key;
    }

}
