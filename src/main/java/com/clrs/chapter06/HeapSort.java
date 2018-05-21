package com.clrs.chapter06;

import java.util.Arrays;

public class HeapSort {

    /**
     * restore max-heap property (childen are lesser than its parent)for the heap with
     * parent node at index i
     * assumes children of A[i] are roots of max-heaps
     *
     * @param a
     * @param i
     * @param maxHeapIndex
     */
    public void maxHeapify(int[] a, int i, int maxHeapIndex) {
        System.out.println(Arrays.toString(a));
        int left = 2 * i + 1;
        int right = left + 1;
        int largest;
        if (left <= maxHeapIndex && a[left] > a[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right <= maxHeapIndex && a[right] > a[largest]) {
            largest = right;
        }

        if (largest != i) {
            exchange(a, largest, i);
            maxHeapify(a, largest, maxHeapIndex);
        }
    }


    public void minHeapify(int[] a, int i, int maxHeapIndex) {
        System.out.println(Arrays.toString(a));
        int left = 2 * i + 1;
        int right = left + 1;
        int smallest;
        if (left <= maxHeapIndex && a[left] < a[i]) {
            smallest = left;
        } else {
            smallest = i;
        }

        if (right <= maxHeapIndex && a[right] < a[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            exchange(a, smallest, i);
            minHeapify(a, smallest, maxHeapIndex);
        }
    }

    private static void exchange(int[] a, int j, int i) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
