package com.clrs.chapter02.exercises;

import com.clrs.Utils;
/***
 * See https://atekihcan.github.io/CLRS/E02.03-04/
 * before solving this
 */
import java.util.Arrays;

public class InsertionSortWithRecursion {
    public static void sort(int[] a, int n) {
        if (n >= 1) {
            sort(a, n - 1);
            insert(a, n);
        }
    }

    private static void insert(int[] a, int j) {
        int key = a[j];
        int i = j - 1;

        while (i >= 0 && key < a[i]) {
            a[i + 1] = a[i];
            i = i - 1;
        }

        a[i + 1] = key;
    }

}
