package com.clrs.chapter06;

import com.clrs.Utils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PriorityQueueTest {


    @Test
    public void testMax() {
        PriorityQueue priorityQueue = new PriorityQueue(new int[]{15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1}, 12);
        assertEquals(15, priorityQueue.max());

    }

    @Test
    public void testExtractMax() {
        PriorityQueue priorityQueue = new PriorityQueue(new int[]{15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1}, 12);
        assertEquals(15, priorityQueue.extractMax());
        assertEquals(11, priorityQueue.getHeapSize());
    }

    @Test
    public void testIncreaseKey() {
        int[] a = new int[]{15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1};
        PriorityQueue priorityQueue = new PriorityQueue(a, 11);
        priorityQueue.increaseKey(4, 19);
        assertEquals(19, priorityQueue.max());
    }

    @Test
    public void testInsert() {
        int[] a = new int[50];
        PriorityQueue priorityQueue = new PriorityQueue(a, 0);
        int b[] = Utils.getArrayRandomPositives(10, 10);

        for (int i = b.length - 1; i >= 0; i--) {
            priorityQueue.insert(b[i]);
        }
        assertEquals(10, priorityQueue.getHeapSize());
        System.out.println(Arrays.toString(a));
    }
}
