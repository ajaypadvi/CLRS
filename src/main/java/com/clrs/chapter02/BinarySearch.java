package com.clrs.chapter02;

import com.clrs.chapter02.exercises.MergeSortWithoutSentinel;

import java.util.Arrays;

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

//    public static void main(String[] args) {
//        //Using iterative binary search
//        int[] a = {1, 3, 5, 7, 9, 2, 30, 32};
//        MergeSortWithoutSentinel.mergeSort(a, 0, 7);
//
//        System.out.println("Sorted # " + Arrays.toString(a));
//        int result = BinarySearch.iterativeBinarySearch(a, 30);
//        System.out.println(result);
//
//        result = BinarySearch.iterativeBinarySearch(a, 32);
//        System.out.println(result);
//
//        result = BinarySearch.iterativeBinarySearch(a, 44);
//        System.out.println(result);
//
//        System.out.println("##############");
//        //Using Recursive Binary Search
//        int[] b = {1, 3, 5, 7, 9, 2, 30, 32};
//        MergeSortWithoutSentinel.mergeSort(a, 0, 7);
//
//        System.out.println("Sorted # " + Arrays.toString(a));
//        int r = BinarySearch.recursiveBinarySearch(a, 0, 7, 30);
//        System.out.println(r);
//
//        r = BinarySearch.recursiveBinarySearch(a, 0, 7, 32);
//        System.out.println(r);
//
//        r = BinarySearch.recursiveBinarySearch(a, 0, 7, 44);
//        System.out.println(r);
//    }
}
