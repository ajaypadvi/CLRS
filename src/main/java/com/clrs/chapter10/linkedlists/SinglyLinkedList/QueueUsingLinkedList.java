package com.clrs.chapter10.linkedlists.SinglyLinkedList;

/**
 * Exercise 10.2-3
 */
public class QueueUsingLinkedList {

    private LinkedList linkedList;

    public QueueUsingLinkedList() {
        this.linkedList = new LinkedList();
    }


    /**
     * Remove First from head
     */
    public void enqueue(int x) {
        linkedList.insertFromRear(x);
    }

    /**
     * Insert last from tail
     *
     * @return
     */
    public int dequeue() {
        return linkedList.deleteFromHead();
    }

    public void display(){
        linkedList.displayList();
    }
}
