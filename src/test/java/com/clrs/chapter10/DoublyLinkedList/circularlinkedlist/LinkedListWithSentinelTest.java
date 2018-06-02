package com.clrs.chapter10.DoublyLinkedList.circularlinkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListWithSentinelTest {

    @Test
    public void test() {
        LinkedListWithSentinel linkedList = new LinkedListWithSentinel();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.insert(40);
        linkedList.insert(50);

        System.out.println("Original--");
        System.out.println(linkedList);
        //Deleting 40
        System.out.println("--Deleting 40");
        LinkedListWithSentinel.Node node = linkedList.delete(40);
        assertEquals(40, node.getKey());

        //Deleting 10
        System.out.println("--Deleting 10");
        node = linkedList.delete(10);
        assertEquals(10, node.getKey());

        //Deleting non-existent key 40
        System.out.println("--Deleting non-existent key 40");
        node = linkedList.delete(40);
        assertEquals(LinkedListWithSentinel.SENTINEL_VALUE, node.getKey());


        //Inserting 60 & 70
        System.out.println("--Inserting 60 & 70");
        linkedList.insert(60);
        linkedList.insert(70);

        System.out.println(linkedList.toString());

        assertEquals(5, linkedList.getSize());
    }
}
