package com.clrs.chapter06;

import java.util.Arrays;

/**
 * Implementation of maximum priority queue
 */
public class PriorityQueue1 {
    private int[] a;
    private int heapSize;

    public PriorityQueue1(int[] a, int heapSize) {
        this.a = a;
        this.heapSize = heapSize;
    }

    /**
     * To peep the maximum from priority queue
     * This API does not remove en element from the queue
     *
     * @return maximum from queue
     */
    public int max() {
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
    public int extractMax() {
        if (heapSize < 0) {
            throw new IllegalArgumentException("Heap underflow error");
        }
        int max = a[0];
        a[0] = a[heapSize - 1];
        maxHeapify(a, 0, heapSize - 1);
        heapSize--;
        return max;
    }

    /**
     * It increases the key value of ith index from priority queue
     *
     * @param i
     * @param key
     */
    public void increaseKey(int i, int key) {
        if (key < a[i]) {
            throw new IllegalArgumentException("The key is smaller than the current key");
        }
        a[i] = key;
        while (i > 0 && a[parent(i)] < a[i]) {
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
        a[heapSize] = Integer.MIN_VALUE;
        increaseKey(heapSize, key);
        heapSize++;
    }


    public int getHeapSize() {
        return heapSize;
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

    private void exchange(int[] a, int j, int i) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    private int parent(int i) {
        return i / 2;
    }
}
