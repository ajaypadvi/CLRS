package com.clrs.chapter06;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

public class HeapSortTest {
    private HeapSort heapSort;

    @Before
    public void setUp() {
        heapSort = new HeapSort();
    }

    @Test
    public void test_maxHeapify1() {
        int[] a = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        heapSort.maxHeapify(a, 1, a.length - 1);
        assertArrayEquals(new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1}, a);
        System.out.println("Maximum heapified array # " + Arrays.toString(a));
    }

    @Test
    public void test_maxHeapify2() {
        int[] a = {3, 4, 10, 14, 7, 9};
        heapSort.maxHeapify(a, 0, a.length - 1);
        assertArrayEquals(new int[]{10, 4, 9, 14, 7, 3}, a);
        System.out.println("Maximum heapified array # " + Arrays.toString(a));
    }

    @Test
    public void test_minHeapify1() {
        int[] a = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        heapSort.minHeapify(a, 0, a.length - 1);
        assertArrayEquals(new int[]{4, 7, 10, 14, 1, 9, 3, 2, 8, 16}, a);
        System.out.println("Maximum heapified array # " + Arrays.toString(a));
    }

    @Test
    public void test_minHeapify2() {
        int[] a = {10, 4, 9, 14, 7, 3};
        heapSort.maxHeapify(a, 0, a.length - 1);
        assertArrayEquals(new int[]{10, 4, 9, 14, 7, 3}, a);
        System.out.println("Maximum heapified array # " + Arrays.toString(a));
    }

    public void test_heapSort1() {

    }

    public void test_heapSort2() {

    }

    public void test_heapSort3() {

    }
}
