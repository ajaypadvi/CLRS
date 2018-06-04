package com.clrs.chapter10.linkedlists.DoublyLinkedList.circularlinkedlist;

public class LinkedListWithSentinel {

    private Node sentinel;
    public static final int SENTINEL_VALUE = Integer.MIN_VALUE;
    private int elements;

    public LinkedListWithSentinel() {
        //Sentinel node's next and prev pointers points to itself
        sentinel = new Node(SENTINEL_VALUE);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public Node search(int x) {
        Node node = this.sentinel.next;
        while (this.sentinel != node && node.key != x) {
            node = node.next;
        }
        return node;
    }

    public Node insert(int x) {
        Node nodeToInsert = new Node(x);
        nodeToInsert.next = this.sentinel.next;
        this.sentinel.next.prev = nodeToInsert;
        nodeToInsert.prev = this.sentinel;
        this.sentinel.next = nodeToInsert;

        elements++;

        return nodeToInsert;
    }

    public Node delete(int x) {
        Node nodeToDelete = search(x);
        if (nodeToDelete != this.sentinel) {
            nodeToDelete.prev.next = nodeToDelete.next;
            nodeToDelete.next.prev = nodeToDelete.prev;

            // Clearing out next and prev pointers of node deleted from above statements
            // so that it can be GC'ed
            nodeToDelete.next = null;
            nodeToDelete.prev = null;
            elements--;
        }
        return nodeToDelete;
    }

    public int getSize() {
        return elements;
    }

    /**
     * Exercise 10.2-6
     * The dynamic-set operation Union takes two disjoint set S1 and S2 as input, and it returns a set
     * S = S1 [ S2 consisting of all the elements of S1 and S2. The sets S1 and S2 are usually destroyed
     * by the operation. Show how to support Union in O (1) time using a suitable list data structure.
     *
     * @param list
     */
    public void union(LinkedListWithSentinel list) {
        this.sentinel.prev.next = list.sentinel.next;
        list.sentinel.next.prev = this.sentinel;
        list.sentinel.prev.next = this.sentinel;
        this.sentinel.prev = list.sentinel.prev;

        this.elements += list.elements;
    }

    @Override
    public String toString() {
        Node startNode = this.sentinel.next;
        StringBuilder text = new StringBuilder();
        while (this.sentinel != startNode) {
            text.append(startNode.key + " ");
            startNode = startNode.next;
        }
        return text.toString();
    }

    public static class Node {
        private int key;
        private Node next;
        private Node prev;

        public Node(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

}
