package com.clrs.chapter02.exercises;

import com.clrs.Utils;
/***
 * See https://atekihcan.github.io/CLRS/E02.03-04/
 * before solving this
 */
import java.util.Arrays;

public class Exercise_2_3_4 {
    public static void insertionSortUsingRecursion(int[] a, int n) {
        if (n >= 1) {
            insertionSortUsingRecursion(a, n - 1);
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

    public static void main(String[] args) {
        int[] a = {5, 2, 4, 6, 1, 3};
        insertionSortUsingRecursion(a, a.length - 1);
        System.out.println("After Sorting # " + Arrays.toString(a));


        int[] randomArray = Utils.getArrayRandomPositives(15, 100);
        System.out.println("Original array with random element # " + Arrays.toString(randomArray));
        insertionSortUsingRecursion(randomArray, randomArray.length - 1);
        System.out.println("Sorted array #" + Arrays.toString(randomArray));

    }
}
