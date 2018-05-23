package com.clrs.chapter06;

import com.clrs.Utils;
import org.junit.Test;
import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class PriorityQueue2Test {

    @Test
    public void testMin() {

        int[] a = {15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1};
        PriorityQueue2.buildMinimumHeap(a);
        System.out.println("Minimum heap constructed # " + Arrays.toString(a));
        PriorityQueue2 priorityQueue2 = new PriorityQueue2(a, a.length);
        assertEquals(0, priorityQueue2.min());
    }

    @Test
    public void testExtractMin() {
        int[] a = {15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1};
        PriorityQueue2.buildMinimumHeap(a);
        System.out.println("Minimum heap constructed # " + Arrays.toString(a));
        PriorityQueue2 priorityQueue2 = new PriorityQueue2(a, a.length);
        assertEquals(0, priorityQueue2.extractMin());
        assertEquals(11, priorityQueue2.getHeapSize());
        System.out.println("Heap after extraction # " + Arrays.toString(a));
    }

    @Test
    public void testDecreaseKey() {

        int[] a = {15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1};

        PriorityQueue2.buildMinimumHeap(a);
        System.out.println("Minimum heap constructed # " + Arrays.toString(a));
        PriorityQueue2 priorityQueue2 = new PriorityQueue2(a, a.length);
        priorityQueue2.decreaseKey(7, 10);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testInsert() {
        int[] a = new int[50];
        PriorityQueue2 priorityQueue2 = new PriorityQueue2(a, 0);
        int b[] = Utils.getArrayRandomPositives(10, 100);

        System.out.println("Elements to be inserted # " + Arrays.toString(b));
        for (int i = b.length - 1; i >= 0; i--) {
            priorityQueue2.insert(b[i]);
        }
        assertEquals(10, priorityQueue2.getHeapSize());
        System.out.println(Arrays.toString(a));
    }
}
