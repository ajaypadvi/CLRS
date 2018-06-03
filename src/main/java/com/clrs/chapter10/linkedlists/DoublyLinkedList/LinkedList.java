package com.clrs.chapter10.linkedlists.DoublyLinkedList;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public Node search(int x) {
        Node node = this.head;
        while (node != null && node.getKey() != x) {
            node = node.next;
        }
        return node;
    }

    public Node insert(int x) {
        Node newNode = new Node(x, null, null);
        newNode.next = this.head;
        if (this.head != null)
            this.head.prev = newNode;
        this.head = newNode;
        newNode.prev = null;
        return newNode;
    }

    public Node delete(int x) {
        Node nodeToDelete = search(x);//O(n)
        if (nodeToDelete != null) {
            if (nodeToDelete.prev != null) {
                nodeToDelete.prev.next = nodeToDelete.next;
            } else {
                this.head = nodeToDelete.next;
            }
            if (nodeToDelete.next != null) {
                nodeToDelete.next.prev = nodeToDelete.prev;
            }
            //Nullify dangling pointers to next and prev from deleted node to help it GC'ed
            nodeToDelete.next = null;
            nodeToDelete.prev = null;
            return nodeToDelete;
        }
        return null;
    }

    @Override
    public String toString() {
        Node startNode = this.head;
        StringBuilder text = new StringBuilder();
        while (startNode != null && startNode.next != null) {
            text.append(startNode.key + "\n");
            startNode = startNode.next;
        }
        return text.toString() + startNode.key;
    }

    public static class Node {
        private int key;
        private Node next;
        private Node prev;

        public Node(int key, Node next, Node prev) {
            this.key = key;
            this.next = next;
            this.prev = prev;
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
