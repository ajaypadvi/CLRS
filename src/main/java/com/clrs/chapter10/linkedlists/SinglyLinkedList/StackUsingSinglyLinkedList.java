package com.clrs.chapter10.linkedlists.SinglyLinkedList;

/**
 * Example 10.2-2
 */
public class StackUsingSinglyLinkedList {

    private LinkedList linkedList;

    public StackUsingSinglyLinkedList(LinkedList linkedList) {
        this.linkedList = linkedList;
    }

    public boolean stackEmpty() {
        if (linkedList.getElements() == 0)
            return true;
        return false;
    }

    public void push(int x) {
        linkedList.insertFromFront(x);
    }

    public int pop() {
        return linkedList.deleteFromHead();
    }

    public void display() {
        linkedList.displayList();
    }
}
