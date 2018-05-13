package com.clrs.chapter02;

import java.util.Arrays;
import java.util.Random;

/**
 * Exercises 2.1-2
 */
public class InsertionSortDecreasingOrder {

    /**
     * insertion sort with O(n^2) time complexity
     *
     * @param a an int array which is to be sorted using insertion sort
     * @return sorted array
     */
    public static int[] reverseSort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            int i = j - 1;

            while (i >= 0 && key > a[i]) {
                a[i + 1] = a[i];
                i = i - 1;
            }

            a[i + 1] = key;
        }
        return a;
    }


    public static void main(String[] args) {
        int[] input = {5, 2, 4, 6, 1, 3};
        System.out.println(Arrays.toString(reverseSort(input)));

        //Now sorting an array filled with random integers

        Random random = new Random();

        int[] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }

        System.out.println("Original array before sorting takes place " + Arrays.toString(array));

        reverseSort(array);

        System.out.println("Sorted array " + Arrays.toString(array));
    }
}
