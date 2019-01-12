package com.clrs.chapter02;

/**
 * Exercises 2.1-1
 * @author Padvi
 */
public class InsertionSort {

    /**
     * insertion sort with O(n^2) time complexity
     *
     * @param a an int array which is to be sorted using insertion sort
     * @return sorted array
     */
    public static void sort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            int i = j - 1;

            while (i >= 0 && key < a[i]) {
                a[i + 1] = a[i];
                i = i - 1;
            }
            a[i + 1] = key;
        }
    }

}
