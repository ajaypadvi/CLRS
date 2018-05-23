package com.clrs.chapter06;

import com.clrs.Utils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PriorityQueue1Test {


    @Test
    public void testMax() {
        PriorityQueue1 priorityQueue1 = new PriorityQueue1(new int[]{15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1}, 12);
        assertEquals(15, priorityQueue1.max());

    }

    @Test
    public void testExtractMax() {
        PriorityQueue1 priorityQueue1 = new PriorityQueue1(new int[]{15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1}, 12);
        assertEquals(15, priorityQueue1.extractMax());
        assertEquals(11, priorityQueue1.getHeapSize());
    }

    @Test
    public void testIncreaseKey() {
        int[] a = new int[]{15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1};
        PriorityQueue1 priorityQueue1 = new PriorityQueue1(a, 11);
        priorityQueue1.increaseKey(4, 19);
        assertEquals(19, priorityQueue1.max());
    }

    @Test
    public void testInsert() {
        int[] a = new int[50];
        PriorityQueue1 priorityQueue1 = new PriorityQueue1(a, 0);
        int b[] = Utils.getArrayRandomPositives(10, 10);

        for (int i = b.length - 1; i >= 0; i--) {
            priorityQueue1.insert(b[i]);
        }
        assertEquals(10, priorityQueue1.getHeapSize());
        System.out.println(Arrays.toString(a));
    }
}
