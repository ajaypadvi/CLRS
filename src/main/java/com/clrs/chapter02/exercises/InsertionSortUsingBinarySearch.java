package com.clrs.chapter02.exercises;

import java.util.Arrays;

/**
 * Insertion sort using binary search
 * Read before looking at below URL
 * https://atekihcan.github.io/CLRS/E02.03-06/
 */
public class InsertionSortUsingBinarySearch {


    public static void sort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            int i = j - 1;

            int mid = binarySearch(a, key, 0, i);
            while (i >= mid) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = key;

        }
    }

    private static int binarySearch(int a[], int item, int low, int high) {
        if (high <= low)
            return (item > a[low]) ? (low + 1) : low;

        int mid = (low + high) / 2;

        if (item == a[mid])
            return mid + 1;

        if (item > a[mid])
            return binarySearch(a, item, mid + 1, high);
        return binarySearch(a, item, low, mid - 1);
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 8, 11, 6, 3, 9, 27};
        sort(a);
        System.out.println("Sorted array # " + Arrays.toString(a));
    }
}