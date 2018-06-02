package com.clrs.chapter10.stacksqueues;

import com.clrs.chapter10.stacksqueues.QueueUsingTwoStacks;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueUsingTwoStacksTest {

    @Test
    public void test() {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks(6, 6);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11);
        queue.enqueue(12);

        // To test FIFO function of queue , lets pop elements of queue one by one ,
        // they should be in the same
        // order in which they were inserted before
        for (int i = 1; i <= 12; i++) {
            assertEquals(i, queue.dequeue());
        }
    }

    @Test(expected = QueueUsingTwoStacks.QueueUsingTwoStacksOverflow.class)
    public void testQueueOverflow() {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks(6, 6);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11);
        queue.enqueue(12);

        //Below statement will cause queu overflow error
        queue.enqueue(13);

    }

    @Test(expected = QueueUsingTwoStacks.QueueUsingTwoStacksUnderflow.class)
    public void testQueueUnderflow() {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks(6, 6);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11);
        queue.enqueue(12);

        for (int i = 1; i <= 12; i++) {
            assertEquals(i, queue.dequeue());
        }

        //Below statement will cause queue underflow error
        queue.dequeue();
    }
}
