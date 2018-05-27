package com.clrs.chapter10;

import java.util.Arrays;

public class Queue {

    private int[] q;
    private int head;
    private int tail;
    private int elements;// This extra attribute is to make sure that queue wont overflow or underflow

    public Queue(int size) {
        this.head = 0;
        this.tail = 0;
        this.elements = 0;
        this.q = new int[size];
    }

    public void enqueue(int x) {
        if (elements == q.length) {
            throw new QueueOverflowException();
        }
        q[tail] = x;
        if (tail == q.length - 1) {
            tail = 0;//wraparound
        } else {
            tail = tail + 1;
        }
        elements++;
        System.out.println("After Enqueue operation : " + toString());
    }

    public int dequeue() {
        if (elements == 0) {
            throw new QueueUnderflowException();
        }
        int x = q[head];
        if (head == q.length - 1) {
            head = 0; //wraparound
        } else {
            head = head + 1;
        }
        elements--;
        System.out.println("After Dequeue operation : " + toString());
        return x;
    }

    public int getTail() {
        return tail;
    }

    public int getHead() {
        return head;
    }

    @Override
    public String toString() {
        return "#Head=" + head + " #Tail=" + tail + " #Array=" + Arrays.toString(q) + " # Number of elements=" + elements;
    }

    static class QueueOverflowException extends RuntimeException {

        QueueOverflowException() {
            super("queue overflow");
        }
    }

    static class QueueUnderflowException extends RuntimeException {
        QueueUnderflowException() {
            super("queue underflow");
        }
    }
}
