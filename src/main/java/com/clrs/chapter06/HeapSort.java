package com.clrs.chapter06;

import java.util.Arrays;

public class HeapSort {

    public void heapSort(int[] a) {
        buildMaximumHeap(a);
        int maxheapIndex = a.length - 1;
        for (int i = a.length - 1; i > 0; i--) {
            exchange(a, 0, i);  // since A[0] is max element
            maxheapIndex--;
            maxHeapify(a, 0, maxheapIndex);
            System.out.println();
        }
    }

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

    //Turn an arbitrary array into a maximum heap
    private void buildMaximumHeap(int[] a) {
        int maxHeapIndex = a.length - 1;
        for (int i = maxHeapIndex / 2; i >= 0; i--) {
            maxHeapify(a, i, maxHeapIndex);
        }

        System.out.println("Maximum Heap built # " + Arrays.toString(a));
    }

    private void exchange(int[] a, int j, int i) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
