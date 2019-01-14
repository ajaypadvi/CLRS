package com.clrs.chapter02.problems;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Bubble sort
 * <p>
 * Refer https://atekihcan.github.io/CLRS/P02-02/ for the running time although the maintenance part is not quite true
 */
public class Problem_2_2_BubbleSort {

    public static void sort(int[] a) {
        boolean elementsSwapped = false;
        for (int i = 0; i < a.length - 2; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    elementsSwapped = true;
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
            if (!elementsSwapped) { // if no elements were swapped then the array was already sorted as determined in the first iteration of the inner loop
                // This condition is to break the sort after first pass when no swapings are required in the further passes
                // It will dramatically reduce the growth rate when array given is already sorted
                // This tells that Bubble Sort has the best case time complexity of O(n)
                System.out.println("Array is already sorted because no swaps were done in the first pass");
                break;
            }
        }

    }

}
