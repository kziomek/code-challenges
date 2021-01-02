package com.krzysztofziomek.codility;

class Nesting {

    private static class Stack {
        char[] S;
        int topS;
        Stack(int size) {
            S = new char[size];
            topS = -1;
        }

        public boolean isEmpty() {
            return topS == -1;
        }

        public void push(char s) {
            S[++topS] = s;
        }

        public char pop() {
            return S[topS--];
        }
    }

    public int solution(String S) {
        Stack stack = new Stack(S.length());
        for (char s: S.toCharArray()) {
            if (s == '(') {
                stack.push(s);
            } else if (s == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
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