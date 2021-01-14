package com.krzysztofziomek.recursive;

public class HanoiTower {

    public void move(int h, Stack A, Stack B, Stack C) {
        if (h == 1) {
            System.out.println("move " + A.peek() + " from " + A.name() + " to " + B.name());
            B.push(A.pop());
            return;
        }
        move(h-1, A, C, B);
        System.out.println("move " + A.peek() + " from " + A.name() + " to " + B.name());
        B.push(A.pop());
        move(h-1, C, B, A);
    }

    private static class Stack {
        private int[] s = new int[10];
        private int size = 0;
        private final String name;

        public Stack(String name) {
            this.name = name;
        }

        public int pop(){
            return s[--size];
        }

        public int peek() {
            return s[size-1];
        }

        public void push(int v) {
            s[size++] = v;
        }
        public int size() {
            return size;
        }
        public String name() {
            return name;
        }
    }

    public static void main(String[] args) {
        Stack source = new Stack("A");
        Stack dest = new Stack("B");
        Stack spare = new Stack("C");
        source.push(3);
        source.push(2);
        source.push(1);

        HanoiTower hanoi = new HanoiTower();
        hanoi.move(source.size(), source, dest, spare);
    }
}