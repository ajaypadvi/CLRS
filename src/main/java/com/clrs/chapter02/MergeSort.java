package com.clrs.chapter02;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    private static int SENTINEL = Integer.MAX_VALUE;

    public static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];

        //assigning sentinels
        left[left.length - 1] = SENTINEL;
        right[right.length - 1] = SENTINEL;

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
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
        }
    }

    public static void sort(int[] a, int p, int r) {
        int q;
        if (p < r) {
            q = (p + r) / 2;
            sort(a, p, q);
            sort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

}
