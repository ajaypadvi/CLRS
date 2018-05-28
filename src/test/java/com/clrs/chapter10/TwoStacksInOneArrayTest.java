package com.clrs.chapter10;

import org.junit.Test;

public class TwoStacksInOneArrayTest {

    @Test
    public void testTwoStacks() {
        TwoStacksInOneArray stacks = new TwoStacksInOneArray(10);

        TwoStacksInOneArray.Stack firstStack = stacks.getFirstStack();
        TwoStacksInOneArray.Stack secondStack = stacks.getSecondStack();

        stacks.push(firstStack, 10);
        stacks.push(firstStack, 20);
        stacks.push(firstStack, 30);
        stacks.push(firstStack, 40);


        stacks.push(secondStack, 50);
        stacks.push(secondStack, 60);
        stacks.push(secondStack, 70);
        stacks.push(secondStack, 80);

        stacks.pop(firstStack);
        stacks.pop(secondStack);
    }

    @Test(expected = TwoStacksInOneArray.StackOverflowException.class)
    public void testStackOverflows() {
        TwoStacksInOneArray stacks = new TwoStacksInOneArray(10);

        TwoStacksInOneArray.Stack firstStack = stacks.getFirstStack();
        TwoStacksInOneArray.Stack secondStack = stacks.getSecondStack();

        stacks.push(firstStack, 10);
        stacks.push(firstStack, 20);
        stacks.push(firstStack, 30);
        stacks.push(firstStack, 40);
        stacks.push(firstStack, 99);


        stacks.push(secondStack, 50);
        stacks.push(secondStack, 60);
        stacks.push(secondStack, 70);
        stacks.push(secondStack, 80);
        stacks.push(secondStack, 91);

        //Below statement will cause stack overflow error
        stacks.push(firstStack, 1000);
    }

    @Test(expected = TwoStacksInOneArray.StackUnderflowException.class)
    public void testStackUnderflow() {

        TwoStacksInOneArray stacks = new TwoStacksInOneArray(10);

        TwoStacksInOneArray.Stack firstStack = stacks.getFirstStack();
        TwoStacksInOneArray.Stack secondStack = stacks.getSecondStack();

        stacks.push(firstStack, 10);
        stacks.push(firstStack, 20);
        stacks.push(firstStack, 30);
        stacks.push(firstStack, 40);
        stacks.push(firstStack, 99);


        stacks.push(secondStack, 50);
        stacks.push(secondStack, 60);
        stacks.push(secondStack, 70);
        stacks.push(secondStack, 80);
        stacks.push(secondStack, 91);

        stacks.pop(firstStack);
        stacks.pop(firstStack);
        stacks.pop(firstStack);
        stacks.pop(firstStack);
        stacks.pop(firstStack);

        //Below will cause stack underflow exception for the first stack
        stacks.pop(firstStack);

        // After the above statement which will cause an expections, all below statements wont run.
        // If you need to test for stack underflow error caused due to second stack then comment the above pop statement
        stacks.pop(secondStack);
        stacks.pop(secondStack);
        stacks.pop(secondStack);
        stacks.pop(secondStack);
        stacks.pop(secondStack);

        //Below will cause stack underflow exception for the second stack
        stacks.pop(secondStack);
    }
}
