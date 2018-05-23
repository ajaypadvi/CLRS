package com.clrs.chapter06;

import java.util.Arrays;

/**
 * Implementation of minimum priority queue
 */
public class PriorityQueue2 {
    private int[] a;
    private int heapSize;

    public PriorityQueue2(int[] a, int heapSize) {
        this.a = a;
        this.heapSize = heapSize;
    }

    /**
     * To peep the maximum from priority queue
     * This API does not remove en element from the queue
     *
     * @return maximum from queue
     */
    public int min() {
        if (a.length == 0) {
            throw new IllegalArgumentException("Heap underflow error");
        }
        return a[0];
    }

    /**
     * To extract/remove maximum from priority queue
     *
     * @return maximum from the queue
     */
    public int extractMin() {
        if (heapSize < 0) {
            throw new IllegalArgumentException("Heap underflow error");
        }
        int max = a[0];
        a[0] = a[heapSize - 1];
        minHeapify(a, 0, heapSize - 1);
        heapSize--;
        return max;
    }

    /**
     * It decreases the key value of ith index from priority queue
     *
     * @param i
     * @param key
     */
    public void decreaseKey(int i, int key) {
        if (key > a[i]) {
            throw new IllegalArgumentException("The key is greater than the current key");
        }
        a[i] = key;
        while (i > 0 && a[parent(i)] > a[i]) {
            exchange(a, i, parent(i));
            i = parent(i);
        }
    }

    /**
     * Inserts the new key into priority queue
     *
     * @param key
     */
    public void insert(int key) {
        a[heapSize] = Integer.MAX_VALUE;
        decreaseKey(heapSize, key);
        heapSize++;
    }


    public int getHeapSize() {
        return heapSize;
    }

    public static void minHeapify(int[] a, int i, int maxHeapIndex) {
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

    private int parent(int i) {
        return i / 2;
    }

    public static void buildMinimumHeap(int[] a) {
        for (int i = (a.length - 1) / 2; i >= 0; i--) {
            minHeapify(a, i, a.length - 1);
        }
    }
}
