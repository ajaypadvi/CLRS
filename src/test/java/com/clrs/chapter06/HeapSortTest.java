package com.clrs.chapter06;

import com.clrs.Utils;
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

    @Test
    public void test_heapSort1() {
        int[] a = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        heapSort.heapSort(a);
        assertArrayEquals(new int[]{1, 2, 3, 4, 7, 8, 9, 10, 14, 16}, a);
        System.out.println("Sorted array using heapsort # " + Arrays.toString(a));
    }

    @Test
    public void test_heapSort2() {
        int[] a = Utils.getArrayRandomPositives(20, 10);
        heapSort.heapSort(a);
        assertTrue(testSort(a));
    }

    private static boolean testSort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
