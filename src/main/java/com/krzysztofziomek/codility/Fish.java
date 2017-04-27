package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 27/04/2017.
 */
class Fish {

    private class Stack {
        long[] S;
        int topS;

        public Stack(int size) {
            S = new long[size];
            topS = -1;
        }

        public void push(long fish) {
            topS++;
            S[topS] = fish;
        }

        public long peek() {
            return S[topS];
        }

        public long pop() {
            long fish = S[topS];
            topS--;
            return fish;
        }

        public boolean isEmpty() {
            return topS == -1;
        }

    }

    public int solution(long[] A, long[] B) {
        Stack stack = new Stack(100000);
        int counter = 0;
        for (int i = 0; i < A.length; i++) {
            long right = A[i];
            if (B[i] == 1) {
                stack.push(right);
            } else {
                boolean alive = true;
                while (!stack.isEmpty() && alive) {
                    long left = stack.peek();
                    if (left > right) {
                        alive = false;
                    } else {
                        stack.pop();
                    }
                }
                if (stack.isEmpty() && alive) {
                    counter++;
                }

            }

        }
        while (!stack.isEmpty()) {
            stack.pop();
            counter++;
        }
        return counter;

    }

}
