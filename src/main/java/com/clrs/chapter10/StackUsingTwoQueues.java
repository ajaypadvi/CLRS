package com.clrs.chapter10;

/**
 * Implementation by making POP operation costly
 * PUSH: O(1)
 * POP : O(n)
 */
public class StackUsingTwoQueues {

    private Queue q1;
    private Queue q2;

    StackUsingTwoQueues(int size) {
        this.q1 = new Queue(size, "Q1");
        this.q2 = new Queue(size, "Q2");
    }

    private boolean queueFull(Queue queue) {
        if (queue.getElements() == queue.getMaxSize())
            return true;
        return false;
    }

    private boolean queueEmpty(Queue queue) {
        if (queue.getElements() == 0)
            return true;
        return false;
    }

    private boolean stackFull() {
        if (queueFull(q1) && queueFull(q2))
            return true;
        return false;
    }

    private boolean stackEmpty() {
        if (queueEmpty(q1) && queueEmpty(q2))
            return true;
        return false;
    }

    public void push(int x) {
        if (stackFull()) {
            throw new StackUsingTwoQueuesOverflow();
        }
        if (queueEmpty(q2)) {
            q1.enqueue(x);
        } else {
            q2.enqueue(x);
        }
    }

    public int pop() {
        if (stackEmpty()) {
            throw new StackUsingTwoQueuesUnderflow();
        }
        int x;
        if (queueEmpty(q2)) {
            while (Math.abs(q1.getTail() - q1.getHead()) > 1) {
                q2.enqueue(q1.dequeue());
            }
            x = q1.dequeue();
        } else {
            while (Math.abs(q2.getTail() - q2.getHead()) > 1) {
                q1.enqueue(q2.dequeue());
            }
            x = q2.dequeue();
        }
        return x;
    }

    public static final class StackUsingTwoQueuesOverflow extends RuntimeException {
        StackUsingTwoQueuesOverflow() {
            super("stack overflow");
        }
    }

    public static final class StackUsingTwoQueuesUnderflow extends RuntimeException {
        StackUsingTwoQueuesUnderflow() {
            super("stack underflow");
        }
    }
}
