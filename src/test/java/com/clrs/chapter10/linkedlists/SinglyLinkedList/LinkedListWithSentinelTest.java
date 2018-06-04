package com.clrs.chapter10.linkedlists.SinglyLinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListWithSentinelTest {

    @Test
    public void testSearch() {
        LinkedListWithSentinel linkedListWithSentinel = new LinkedListWithSentinel();
        linkedListWithSentinel.insert(10);
        linkedListWithSentinel.insert(20);
        linkedListWithSentinel.insert(30);
        linkedListWithSentinel.insert(40);
        linkedListWithSentinel.insert(50);


        LinkedListWithSentinel.Node node = linkedListWithSentinel.search(30);
        assertEquals(30, node.getKey());

        node = linkedListWithSentinel.search(100);
        assertEquals(node, linkedListWithSentinel.getSentinel());//Returns sentinel as it did not found the node in linked list
    }

    @Test
    public void testInsertDelete() {
        LinkedListWithSentinel linkedListWithSentinel = new LinkedListWithSentinel();
        linkedListWithSentinel.displayList();

        linkedListWithSentinel.insert(10);
        linkedListWithSentinel.insert(20);
        linkedListWithSentinel.insert(30);
        linkedListWithSentinel.insert(40);
        linkedListWithSentinel.insert(50);

        linkedListWithSentinel.displayList();

        linkedListWithSentinel.delete(20);
        linkedListWithSentinel.displayList();

        linkedListWithSentinel.delete(30);
        linkedListWithSentinel.displayList();

        linkedListWithSentinel.delete(10);
        linkedListWithSentinel.displayList();

        linkedListWithSentinel.delete(50);
        linkedListWithSentinel.displayList();
    }
}
