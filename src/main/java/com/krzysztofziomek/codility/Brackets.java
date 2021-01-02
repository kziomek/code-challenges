package com.krzysztofziomek.codility;

/**
 * @author Krzysztof Ziomek
 * @since 27/04/2017.
 */
class Brackets {

    private class Stack {

        char[] S;
        int topS;

        public Stack(int N) {
            S = new char[N];
            topS = -1;
        }

        public void push(char c) {
            S[++topS] = c;
        }

        public char pop() {
            return S[topS--];
        }

        public boolean isEmpty() {
            return topS == -1;
        }
    }

    public int solution(String str) {
        int N = 200000;
        Stack stack = new Stack(N);

        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                char cStack = stack.pop();
                if (c == ')' && cStack == '('
                    || c == '}' && cStack == '{'
                    || c == ']' && cStack == '[') {
                    //OK
                } else {
                    return 0;
                }
            }

        }
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}