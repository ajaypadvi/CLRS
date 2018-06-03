package com.clrs.chapter10.linkedlists.SinglyLinkedList;

import org.junit.Before;
import org.junit.Test;

public class StackUsingSinglyLinkedListTest {
    private StackUsingSinglyLinkedList stack;

    @Before
    public void before() {
        stack = new StackUsingSinglyLinkedList(new LinkedList());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.print("Original List :  ");
        stack.display();
    }

    @Test
    public void testStackPush() {
        stack.display();
        stack.push(60);
        stack.display();
    }

    @Test
    public void testStackPop() {
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.display();
    }
}
