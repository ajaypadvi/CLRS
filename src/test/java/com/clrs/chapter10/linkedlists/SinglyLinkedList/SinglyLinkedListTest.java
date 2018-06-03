package com.clrs.chapter10.linkedlists.SinglyLinkedList;

import org.junit.Test;

public class SinglyLinkedListTest {

    @Test
    public void testInsert() {
        LinkedList singlyLinkedList = new LinkedList();

        singlyLinkedList.displayList();
        singlyLinkedList.insertFromFront(10);
        singlyLinkedList.insertFromFront(20);
        singlyLinkedList.insertFromFront(30);
        singlyLinkedList.insertFromFront(40);
        singlyLinkedList.insertFromFront(50);

        singlyLinkedList.displayList();

        singlyLinkedList.insertFromRear(60);
        singlyLinkedList.insertFromRear(70);
        singlyLinkedList.insertFromRear(80);
        singlyLinkedList.insertFromRear(90);
        singlyLinkedList.insertFromRear(100);

        singlyLinkedList.displayList();

    }

    @Test
    public void deleteFromFront() {
        LinkedList singlyLinkedList = new LinkedList();

        singlyLinkedList.displayList();
        singlyLinkedList.insertFromFront(10);
        singlyLinkedList.insertFromFront(20);
        singlyLinkedList.insertFromFront(30);
        singlyLinkedList.insertFromFront(40);
        singlyLinkedList.insertFromFront(50);

        singlyLinkedList.displayList();

        singlyLinkedList.deleteFromHead();
        singlyLinkedList.deleteFromHead();

        singlyLinkedList.displayList();
    }

    @Test
    public void deleteAny() {
        LinkedList singlyLinkedList = new LinkedList();

        singlyLinkedList.displayList();
        singlyLinkedList.insertFromFront(10);
        singlyLinkedList.insertFromFront(20);
        singlyLinkedList.insertFromFront(30);
        singlyLinkedList.insertFromFront(40);
        singlyLinkedList.insertFromFront(50);

        singlyLinkedList.displayList();

        singlyLinkedList.delete(20);
        singlyLinkedList.displayList();

        singlyLinkedList.delete(30);
        singlyLinkedList.displayList();

        singlyLinkedList.delete(10);
        singlyLinkedList.displayList();

        singlyLinkedList.delete(50);
        singlyLinkedList.displayList();

        singlyLinkedList.delete(40);
        singlyLinkedList.displayList();

        singlyLinkedList.insertFromRear(60);
        singlyLinkedList.insertFromRear(70);
        singlyLinkedList.insertFromRear(80);
        singlyLinkedList.insertFromRear(90);
        singlyLinkedList.insertFromRear(100);

        singlyLinkedList.displayList();

        singlyLinkedList.delete(100);
        singlyLinkedList.displayList();

        singlyLinkedList.delete(90);
        singlyLinkedList.displayList();
    }
}
