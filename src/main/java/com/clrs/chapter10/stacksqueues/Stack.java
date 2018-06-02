package com.clrs.chapter10.stacksqueues;

import java.util.Arrays;

/**
 * Stack Implementation
 */
public class Stack {

    private int[] s;
    private int top;
    private String name;
    private int maxSize; //This is useful when Stack is to be used outside this package where access to array is not allowed to get the overall size

    public Stack(int size, String name) {
        this.s = new int[size];
        this.top = -1;
        this.name = name;
        this.maxSize = size;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getTop() {
        return top;
    }

    private boolean stackFull() {
        if (top == s.length - 1) {
            return true;
        }
        return false;
    }

    private boolean stackEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    public void push(int a) {
        if (stackFull()) {
            throw new StackOverflowException();
        }
        top = top + 1;
        s[top] = a;
        System.out.println(toString());
    }

    public int pop() {
        if (stackEmpty()) {
            throw new StackUnderflowException();
        }
        top = top - 1;
        System.out.println(toString());
        return s[top + 1];
    }

    static class StackOverflowException extends RuntimeException {
        StackOverflowException() {
            super("stack overflow");
        }
    }

    static class StackUnderflowException extends RuntimeException {
        StackUnderflowException() {
            super("stack underflow");
        }
    }

    @Override
    public String toString() {
        return "#Name= " + name + " #Top= " + top + " #Array=" + Arrays.toString(s);
    }
}
