package com.clrs.chapter07;

/**
 * Quick Sort in increasing order
 */
public class QuickSort1 {

    public void quickSort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q + 1, r);
        }
    }

    private int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (a[j] <= x) {
                i = i + 1;
                exchange(a, i, j);
            }
        }
        exchange(a, i + 1, r);
        return i + 1;
    }

    private void exchange(int[] a, int j, int i) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
