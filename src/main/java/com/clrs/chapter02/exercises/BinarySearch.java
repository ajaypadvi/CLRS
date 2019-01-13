package com.clrs.chapter02.exercises;

public class BinarySearch {

    public static int iterativeBinarySearch(int[] a, int v) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (high >= low) {
            mid = ((high - low) / 2) + low;
            if (a[mid] == v) {
                return mid;
            } else if (a[mid] > v) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] a, int low, int high, int v) {
        if (low > high) {
            return -1;
        }
        int mid = ((high - low) / 2) + low;
        if (a[mid] == v) {
            return mid;
        } else if (a[mid] > v) {
            return recursiveBinarySearch(a, low, mid - 1, v);
        } else {
            return recursiveBinarySearch(a, mid + 1, high, v);
        }
    }


}
