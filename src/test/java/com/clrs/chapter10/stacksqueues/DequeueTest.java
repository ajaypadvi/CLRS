package com.clrs.chapter10.stacksqueues;

import com.clrs.chapter10.stacksqueues.Dequeue;
import org.junit.Test;

public class DequeueTest {

    @Test
    public void testDequeue() {
        Dequeue dequeue = new Dequeue(10);
        dequeue.rightEnqueue(10);
        dequeue.rightEnqueue(110);
        dequeue.rightEnqueue(30);
        dequeue.rightEnqueue(40);
        dequeue.rightEnqueue(50);

        dequeue.leftEnqueue(60);
        dequeue.leftEnqueue(70);
        dequeue.leftEnqueue(80);
        dequeue.leftEnqueue(90);
        dequeue.leftEnqueue(100);
    }

    @Test(expected = Dequeue.DequeueOverflowException.class)
    public void testDequeueOverflow() {
        Dequeue dequeue = new Dequeue(10);
        dequeue.rightEnqueue(10);
        dequeue.rightEnqueue(20);
        dequeue.rightEnqueue(30);
        dequeue.rightEnqueue(40);
        dequeue.rightEnqueue(50);

        dequeue.leftEnqueue(60);
        dequeue.leftEnqueue(70);
        dequeue.leftEnqueue(220);
        dequeue.leftEnqueue(90);
        dequeue.leftEnqueue(100);


        //Below statement will cause dequeue overflow excpetion
        dequeue.leftEnqueue(44);
    }

    @Test(expected = Dequeue.DequeueUnderflowException.class)
    public void testDequeueUnderflow() {
        Dequeue dequeue = new Dequeue(10);
        dequeue.rightDequeue();
    }
}
