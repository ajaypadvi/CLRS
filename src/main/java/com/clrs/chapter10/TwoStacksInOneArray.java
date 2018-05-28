package com.clrs.chapter10;

import java.util.Arrays;

/**
 * Exercise 10.1-2
 */
public class TwoStacksInOneArray {

    private final Stack firstStack;
    private final Stack secondStack;
    private final int[] a;

    public TwoStacksInOneArray(int size) {
        this.a = new int[size];
        this.firstStack = new Stack(a, 0, -1, " FIRST STACK");
        this.secondStack = new Stack(a, size - 1, size, "SECOND STACK");
    }

    private boolean stackEmpty(Stack stack) {
        if (stack.bottom == 0) {//First stack
            if (stack.top == -1) {
                return true;
            }
        } else if (stack.top == a.length) {
            return true;
        }
        return false;
    }

    private boolean stackFull() {
        if (Math.abs(firstStack.top - secondStack.top) == 1) {
            return true;
        }
        return false;
    }

    public void push(Stack stack, int x) {
        if (stackFull()) {
            throw new StackOverflowException();
        } else {
            if (stack.bottom == 0) {//first stack
                stack.top = stack.top + 1;
            } else {
                stack.top = stack.top - 1;
            }
            a[stack.top] = x;
        }
        System.out.println("PUSH : " + stack.toString());
    }

    public int pop(Stack stack) {
        int x;
        if (stackEmpty(stack)) {
            throw new StackUnderflowException();
        } else {
            if (stack.bottom == 0) {//first stack
                stack.top = stack.top - 1;
                x = a[stack.top + 1];
            } else {
                stack.top = stack.top + 1;
                x = a[stack.top - 1];
            }
        }
        System.out.println("POP : " + stack.toString());
        return x;
    }

    public Stack getFirstStack() {
        return firstStack;
    }

    public Stack getSecondStack() {
        return secondStack;
    }

    public static class Stack {
        private int bottom;
        private int top;
        private int[] a;
        private String name;

        Stack(int[] a, int bottom, int top, String name) {
            this.bottom = bottom;
            this.top = top;
            this.a = a;
            this.name = name;
        }


        @Override
        public String toString() {
            return "#Name = " + name + " #Bottom=" + bottom + " #Top=" + top + " #Array=" + Arrays.toString(a);
        }
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
}
