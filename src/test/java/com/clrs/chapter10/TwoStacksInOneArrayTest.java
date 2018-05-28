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

    @Test
    public void testStackOverflows() {

    }

    @Test
    public void testStackUnderflows() {

    }
}
