package com.krzysztofziomek.structures;

public class LinkedList {

    private Node head;
    private Node tail;

    public Node head() {
        return head;
    }

    public void add(Node node) {
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }


    public static class Node {
        private Node next;
        private final String data;

        public Node(String data) {
            this.data = data;
        }

        public String data() {
            return data;
        }

        public Node next() {
            return next;
        }

        private void setNext(Node node) {
            this.next = node;
        }
    }
}