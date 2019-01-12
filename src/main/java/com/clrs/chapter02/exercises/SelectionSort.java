package com.clrs.chapter02.exercises;

public class SelectionSort {
    public static void sort(int[] a) {
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

}
