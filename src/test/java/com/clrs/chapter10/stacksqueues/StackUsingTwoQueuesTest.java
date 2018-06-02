package com.clrs.chapter10.stacksqueues;

import com.clrs.chapter10.stacksqueues.StackUsingTwoQueues;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackUsingTwoQueuesTest {

    @Test
    public void test() {
        StackUsingTwoQueues stack = new StackUsingTwoQueues(10);
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
            System.out.println(stack.pop());
            //assertEquals(100 - i * 10, stack.pop());
        }
    }

    public void testOverflow() {

    }

    public void testUnderflow() {

    }
}
