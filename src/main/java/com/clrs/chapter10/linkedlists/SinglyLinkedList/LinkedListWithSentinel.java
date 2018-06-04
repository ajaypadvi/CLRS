package com.clrs.chapter10.linkedlists.SinglyLinkedList;

/**
 * Exercises 10.2-4 & 10.2-5
 * Circular Singly linked list with sentinel value
 */
public class LinkedListWithSentinel {

    private Node sentinel;
    private static final int SENTINEL_VALUE = Integer.MIN_VALUE;

    public LinkedListWithSentinel() {
        this.sentinel = new Node(SENTINEL_VALUE);
        this.sentinel.next = sentinel;//Sentinel points to itself for empty linked list
    }

    public Node search(int x) {
        sentinel.key = x;
        Node node = sentinel.next;
        while (node.key != x) {
            node = node.next;
        }
        return node;
    }

    public void insert(int x) {
        Node nodeToInsert = new Node(x);
        nodeToInsert.next = sentinel.next;
        sentinel.next = nodeToInsert;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Node current = this.sentinel.next;          // start at beginning
        while (current != sentinel)         // until end of list,
        {
            current.displayKey();      // print data
            current = current.next;     // move to next link
        }
        System.out.println("");
    }

    public void delete(int x) {
        Node pre = sentinel;
        while (pre.next.key != x) {
            if (pre.next == sentinel) {
                throw new IllegalArgumentException("requested value to delete not found in linked list");
            }
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }

    public Node getSentinel() {
        return sentinel;
    }

    public static class Node {
        private Node next;
        private int key;

        public Node(int key) {
            this.key = key;
        }

        public void displayKey()          // display this link
        {
            System.out.print(key + " ");
        }

        public Node getNext() {
            return next;
        }

        public int getKey() {
            return key;
        }
    }
}
