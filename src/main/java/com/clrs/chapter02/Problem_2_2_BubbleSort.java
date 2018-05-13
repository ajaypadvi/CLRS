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
        for (int i = 0; i < a.length - 2; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {

        int[] a = {2, 8, 7, 3, 1, 4, 5, 9};
        System.out.println("before sorting #" + Arrays.toString(a));
        bubbleSort(a);
        System.out.println("after sorting #" + Arrays.toString(a));

    }
}
