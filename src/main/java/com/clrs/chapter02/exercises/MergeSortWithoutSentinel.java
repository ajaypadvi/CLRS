package com.clrs.chapter02.exercises;

public class MergeSortWithoutSentinel {


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
                // If i exceeds length of left array then there is going to be no point in assigning element from left array to A
                // as it will produce IndexOutOfBoundsException and hence will try to assign from right array in below if else condition
                a[k] = right[j];
                j++;
            } else if (j >= n2) {
                // If j exceeds length of right array then there is going to be no point in assigning element from left array to A
                // as it will produce IndexOutOfBoundsException
                a[k] = left[i];
                i++;
            } else if (left[i] <= right[j]) { // From here this is going to be normal algorithm similar to merge sort with sentinels
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
