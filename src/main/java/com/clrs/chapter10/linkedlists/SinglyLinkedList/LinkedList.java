package com.clrs.chapter10.linkedlists.SinglyLinkedList;

/**
 * Example 10.2-1
 */
public class LinkedList {

    private Node head;
    private Node tail;

    private int elements;

    public LinkedList() {
        this.elements = 0;
        this.head = null;
        this.tail = null;
    }

    public Node insertFromFront(int x) {
        Node nodeToInsert = new Node(x);

        if (head == null)
            tail = nodeToInsert;

        nodeToInsert.next = head;
        head = nodeToInsert;

        elements++;
        return nodeToInsert;
    }

    public void insertFromRear(int x) {
        Node nodeToInsert = new Node(x);
        if (tail == null)
            head = nodeToInsert;
        else
            tail.next = nodeToInsert;
        tail = nodeToInsert;
        elements++;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Node current = head;          // start at beginning
        while (current != null)         // until end of list,
        {
            current.displayKey();      // print data
            current = current.next;     // move to next link
        }
        System.out.println("");
    }

    public int deleteFromHead() {
        int x;
        if (head == null) {
            throw new RuntimeException("linked list underflow error");
        } else {
            if (head.next == null) {
                tail = null;
            }
            x = head.key;
            head = head.next;
            elements--;
        }
        return x;
    }

    public void delete(int x) {
        Node pre = head;
        if (pre.key == x) {
            deleteFromHead();
            return;
        }

        while (pre.next.key != x) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        elements--;
    }

    public int getElements() {
        return elements;
    }

    public class Node {
        private Node next;
        private int key;

        public void displayKey()          // display this link
        {
            System.out.print(key + " ");
        }

        public Node(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public Node getNext() {
            return next;
        }
    }
}
