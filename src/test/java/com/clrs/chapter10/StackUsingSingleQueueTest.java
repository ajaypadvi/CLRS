package com.clrs.chapter10;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackUsingSingleQueueTest {

    @Test
    public void test() {
        StackUsingSingleQueue stack = new StackUsingSingleQueue(10);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        stack.push(100);

        //Elements should now be popped in LIFO manner so the first to be popped out of Stack is 100 and the last is 10

        for (int i = 0; i < 10; i++) {
            assertEquals(100 - i * 10, stack.pop());
        }
    }

}
