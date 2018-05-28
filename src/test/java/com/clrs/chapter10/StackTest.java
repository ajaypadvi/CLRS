package com.clrs.chapter10;

import org.junit.Test;

public class StackTest {

    @Test
    public void testStack1() {
        Stack stack = new Stack(10, "name");
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.pop();
        stack.push(8);
        stack.pop();
    }

    @Test(expected = Stack.StackOverflowException.class)
    public void testOverflow() {
        Stack stack = new Stack(6, "name");
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        stack.push(55);
        stack.push(66);

        //Below operation will cause stack overflow error
        stack.push(77);
    }

    @Test(expected = Stack.StackUnderflowException.class)
    public void testUnderflow() {
        Stack stack = new Stack(6, "name");
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        stack.push(55);
        stack.push(66);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        //  Below operation will cause stack underflow error
        stack.pop();
    }
}
