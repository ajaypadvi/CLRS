package com.clrs.chapter10;

import java.util.Queue;

/**
 * Exercise 10.1-6
 * ENQUEUE ->PUSH(S1) ->Can overflow
 * DEQUEUE ->POP(S2) ->Can underflow
 * <p>
 * When S1 overflows, transmit as much elements from S1 to S2
 * When S2 under-flows, transmit as much elements from S1 to S2
 */
public class QueueUsingTwoStacks {
    private Stack firstStack;
    private Stack secondStack;

    public QueueUsingTwoStacks(int firstStackSize, int secondStackSize) {
        this.firstStack = new Stack(firstStackSize, "FIRST STACK");
        this.secondStack = new Stack(secondStackSize, "SECOND STACK");
    }

    private boolean stackFull(Stack stack) {
        if (stack.getTop() == stack.getMaxSize() - 1) {
            return true;
        }
        return false;
    }

    private boolean stackEmpty(Stack stack) {
        if (stack.getTop() == -1) {
            return true;
        }
        return false;
    }


    private boolean queueFull() {
        if (stackFull(firstStack) && stackFull(secondStack)) {
            return true;
        }
        return false;
    }

    private boolean queueEmpty() {
        if (stackEmpty(firstStack) && stackEmpty(secondStack)) {
            return true;
        }
        return false;
    }

    public void enqueue(int x) {
        if (queueFull()) {
            throw new QueueUsingTwoStacksOverflow();
        } else {
            if (stackFull(firstStack)) {
                transmit(firstStack, secondStack);
            }
            firstStack.push(x);
        }
    }

    public int dequeue() {
        int x;
        if (queueEmpty()) {
            throw new QueueUsingTwoStacksUnderflow();
        } else {
            if (stackEmpty(secondStack)) {
                transmit(firstStack, secondStack);
            }
            x = secondStack.pop();
        }
        return x;
    }

    private void transmit(Stack source, Stack destination) {
        if (stackEmpty(secondStack)) {
            pour(firstStack, secondStack);
        } else {
            Stack temp = new Stack(secondStack.getMaxSize(), "temp");
            pour(secondStack, temp);
            pour(firstStack, temp);
            pour(temp, secondStack);
        }
    }

    private void pour(Stack source, Stack destination) {
        while (!stackFull(destination)) {
            destination.push(source.pop());
        }
    }

    @Override
    public String toString() {
        return firstStack.toString() + " ; " + secondStack.toString();
    }

    public final static class QueueUsingTwoStacksOverflow extends RuntimeException {
        QueueUsingTwoStacksOverflow() {
            super("queue overflow");
        }
    }

    public final static class QueueUsingTwoStacksUnderflow extends RuntimeException {
        QueueUsingTwoStacksUnderflow() {
            super("queue underflow");
        }
    }
}

