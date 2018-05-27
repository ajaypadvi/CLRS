package com.clrs.chapter10;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void testQueue1() {
        Queue queue = new Queue(6);
        queue.enqueue(4);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(8);
        queue.dequeue();
        assertEquals(2, queue.getHead());
        assertEquals(4, queue.getTail());
    }

    @Test(expected = Queue.QueueOverflowException.class)
    public void testOverflow() {
        Queue queue = new Queue(6);
        queue.enqueue(4);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(44);
        queue.enqueue(33);


        //Below will cause queue overflow error
        queue.enqueue(10);
    }

    @Test(expected = Queue.QueueUnderflowException.class)
    public void testUnderflow() {
        Queue queue = new Queue(6);
        queue.enqueue(4);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(9);

        assertEquals(4, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(6, queue.dequeue());
        assertEquals(8, queue.dequeue());
        assertEquals(9, queue.dequeue());

        //Below will cause queue underflow exception
        queue.dequeue();
    }
}
