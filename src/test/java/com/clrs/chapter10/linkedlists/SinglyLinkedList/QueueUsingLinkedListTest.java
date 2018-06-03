package com.clrs.chapter10.linkedlists.SinglyLinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueUsingLinkedListTest {

    @Test
    public void test() {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);

        queue.display();

        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
        assertEquals(40, queue.dequeue());
        assertEquals(50, queue.dequeue());
        assertEquals(60, queue.dequeue());

        queue.display();

    }
}
