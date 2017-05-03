package com.krzysztofziomek.fb;

/**
 * @author Krzysztof Ziomek
 * @since 03/05/2017.
 */
public class LargestRectangle {


    public class Stack{
        int S[] = new int[10];
        int posS = -1;

        public void push(int key){
            posS++;
            S[posS]=key;
        }
        public int peek(){
            return S[posS];
        }
        public boolean isEmpty() {
            return posS == -1;
        }
        public int pop(){
            int key = S[posS];
            posS--;
            return key;
        }

    }

    public int calculate(int A[]) {

        int pos = -1, high, size, maxSize = 0;
        Stack sh = new Stack();
        Stack sp = new Stack();

        for (int i = 0; i < A.length; i++) {

            if (sh.isEmpty()) {
                sh.push(A[i]);
                sp.push(i);
            } else {
                while (!sh.isEmpty() && A[i] < sh.peek()) {
                    pos = sp.pop();
                    high = sh.pop();
                    size = high * (i - pos);
                    maxSize = Math.max(size, maxSize);
                }
                if (sh.isEmpty() || sh.peek() < A[i]) {
                    sh.push(A[i]);
                    if (pos == -1) {
                        sp.push(i);
                    } else {
                        sp.push(pos);
                    }
                }
                pos = -1;
            }

        }
        while (!sh.isEmpty()) {
            pos = sp.pop();
            high = sh.pop();
            size = high * (A.length - pos);
            maxSize = Math.max(size, maxSize);

        }

        return maxSize;
    }
}
