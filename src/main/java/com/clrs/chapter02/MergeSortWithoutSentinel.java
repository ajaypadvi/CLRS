package com.clrs.chapter02;

import java.util.Arrays;
import java.util.Random;

public class MergeSortWithoutSentinel {

    private static int max = Integer.MAX_VALUE;

    public static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] left = new int[n1];
        int[] right = new int[n2];

        int i;
        int j;
        for (i = 0; i < n1; i++) {
            left[i] = a[p + i];
        }

        for (j = 0; j < n2; j++) {
            right[j] = a[q + j + 1];
        }

        i = 0;
        j = 0;
        for (int k = p; k <= r; k++) {
            if (i >= n1) {
                a[k] = right[j];
                j++;
            } else if (j >= n2) {
                a[k] = left[i];
                i++;
            } else if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
        }
    }

    public static void mergeSort(int[] a, int p, int r) {
        int q;
        if (p < r) {
            q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 4, 7, 1, 3, 2, 6};
        mergeSort(a, 0, 7);
        System.out.println(Arrays.toString(a));


        //Now sorting an array filled with random integers

        Random random = new Random();

        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }

        System.out.println("Original array before sorting takes place " + Arrays.toString(array));
        mergeSort(array, 0, 4);
        System.out.println("Sorted array " + Arrays.toString(array));
    }
}
