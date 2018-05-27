package com.clrs.chapter10;

import java.util.Arrays;

/**
 * Stack Implementation
 */
public class Stack {

    private int[] s;
    private int top;

    public Stack(int size) {
        this.s = new int[size];
        this.top = -1;
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
        return "#Top= " + top + " #Array=" + Arrays.toString(s);
    }
}
