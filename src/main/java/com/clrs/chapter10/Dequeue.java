package com.clrs.chapter10;

import java.util.Arrays;

/**
 * Doubly ended queue
 * Exercise 10.1-5
 */
public class Dequeue {

    private int head;
    private int tail;
    private int[] a;
    private int elements;// This extra attribute is to make sure that queue wont overflow or underflow

    public Dequeue(int size) {
        this.a = new int[size];
        this.head = 0;
        this.tail = 0;
        this.elements = 0;
    }

    public void leftEnqueue(int x) {
        if (elements == a.length) {
            throw new DequeueOverflowException();
        }
        if (head == 0) {
            head = a.length - 1;//wraparound
        } else {
            head = head - 1;
        }
        a[head] = x;
        elements++;
        System.out.println("LEFT ENQUEUE : " + toString());
    }

    public void rightEnqueue(int x) {
        if (elements == a.length) {
            throw new Queue.QueueOverflowException();
        }
        a[tail] = x;
        if (tail == a.length - 1) {
            tail = 0;//wraparound
        } else {
            tail = tail + 1;
        }
        elements++;
        System.out.println("RIGHT ENQUEUE : " + toString());
    }

    public int leftDequeue() {
        if (elements == 0) {
            throw new Queue.QueueUnderflowException();
        }
        int x = a[head];
        if (head == a.length - 1) {
            head = 0; //wraparound
        } else {
            head = head + 1;
        }
        elements--;
        System.out.println("LEFT DEQUEUE : " + toString());
        return x;
    }

    public int rightDequeue() {
        if (elements == 0) {
            throw new DequeueUnderflowException();
        }
        int x = a[tail];
        if (tail == 0) {
            tail = a.length - 1;// wraparound
        } else {
            tail = tail - 1;
        }
        return x;
    }

    public static final class DequeueOverflowException extends RuntimeException {
        DequeueOverflowException() {
            super("dequeue overflow");
        }
    }

    public static final class DequeueUnderflowException extends RuntimeException {
        DequeueUnderflowException() {
            super("dequeue underflow");
        }
    }

    @Override
    public String toString() {
        return "#HEAD=" + head + " #TAIL=" + tail + " #ARRAY= " + Arrays.toString(a);
    }
}
