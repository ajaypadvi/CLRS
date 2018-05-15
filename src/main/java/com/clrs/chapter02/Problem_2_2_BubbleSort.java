package com.clrs.chapter02;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Bubble sort
 * <p>
 * Refer https://atekihcan.github.io/CLRS/P02-02/ for the running time although the maintenance part is not quite true
 */
public class Problem_2_2_BubbleSort {

    public static void bubbleSort(int[] a) {
        boolean alreadySorted = true;
        for (int i = 0; i < a.length - 2; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    alreadySorted = false;
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
            if (alreadySorted) {
                // This condition is to break the sort after first pass when no swapings are required in the further passes
                // It will dramatically reduce the growth rate when array given is already sorted
                // This tells that Bubble Sort has the best case time complexity of O(n)
                System.out.println("Array is already sorted because no swaps were done in the first pass");
                break;
            }
        }

    }

    public static void main(String[] args) {

//        int[] a = {2, 8, 7, 3, 1, 4, 5, 9};
//        System.out.println("before sorting #" + Arrays.toString(a));
//        bubbleSort(a);
//        System.out.println("after sorting #" + Arrays.toString(a));

        int[] a = {1, 2, 3, 4, 5, 6};
        System.out.println("before sorting #" + Arrays.toString(a));
        bubbleSort(a);
        System.out.println("after sorting #" + Arrays.toString(a));


    }
}
