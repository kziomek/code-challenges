package com.krzysztofziomek.structures;

/**
 * @author Krzysztof Ziomek
 * @since 27/04/2017.
 */
public class Stack {

    long[] S;
    int topS;

    public Stack(int size) {
        S = new long[size];
        topS = -1;
    }

    public boolean empty() {
        return topS < 0;
    }

    public void push(long key) {
        topS++;
        if (topS >= S.length) {
            topS--;
            throw new IllegalStateException("overflow");
        } else {
            S[topS] = key;
        }
    }

    public long pop() {
        if (empty()) {
            throw new IllegalStateException("underflow");
        } else {
            topS--;
            return S[topS + 1];
        }


    }

}
