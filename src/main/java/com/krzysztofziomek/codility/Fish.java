package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 27/04/2017.
 */
class Fish {

    private static class Stack {
        long[] S;
        int topS;

        public Stack(int size) {
            S = new long[size];
            topS = -1;
        }

        public void push(long fish) {
            S[++topS] = fish;
        }

        public long peek() {
            return S[topS];
        }

        public long pop() {
            return S[topS--];
        }

        public boolean isEmpty() {
            return topS == -1;
        }

        public long size() { return topS + 1; }
    }

    public int solution(long[] A, long[] B) {
        Stack stack = new Stack(100000);
        int survivals = 0;
        for (int i = 0; i < A.length; i++) {
            long fish = A[i];
            if (B[i] == 1) {
                stack.push(fish);
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek() > fish) {
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if (stack.isEmpty()) {
                    survivals++;
                }
            }
        }
        survivals+=stack.size();
        return survivals;
    }
}