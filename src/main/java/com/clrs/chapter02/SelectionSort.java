package com.clrs.chapter02;

import com.clrs.Utils;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] a) {
        int min;
        for (int i = 0; i < a.length - 1; i++) {
            min = i + 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            if (a[i] > a[min]) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 8, 7, 3, 1, 4, 5, 9};
        System.out.println("before sorting #" + Arrays.toString(a));
        selectionSort(a);
        System.out.println("after sorting #" + Arrays.toString(a));


        int[] randomArray = Utils.getArrayRandomPositives(20, 100);
        System.out.println("before sorting # " + Arrays.toString(randomArray));
        selectionSort(randomArray);
        System.out.println("after sorting # " + Arrays.toString(randomArray));
    }
}
