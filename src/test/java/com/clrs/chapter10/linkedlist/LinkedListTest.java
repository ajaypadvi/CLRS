package com.clrs.chapter10.linkedlist;

import com.clrs.chapter10.DoublyLinkedList.linkedlist.LinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {

    @Test
    public void test() {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        System.out.println(list.toString());
        //Searching 30
        LinkedList.Node node = list.search(30);
        assertEquals(node.getKey(), 30);

        node = list.search(10);
        assertEquals(node.getKey(), 10);

        System.out.println("--");
        //Deleting 30
        node = list.delete(30);
        assertEquals(node.getKey(), 30);
        System.out.println(list.toString());


        System.out.println("--");
        //Deleting 10
        node = list.delete(10);
        assertEquals(node.getKey(), 10);
        System.out.println(list.toString());
    }
}
