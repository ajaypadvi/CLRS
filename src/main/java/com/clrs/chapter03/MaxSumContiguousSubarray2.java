package com.clrs.chapter03;

import java.util.Arrays;

/**
 * Using Brute Force method
 * Big O (n^2)
 */
public class MaxSumContiguousSubarray2 {
    private static void maxSubArray(int[] a) {
        System.out.println(Arrays.toString(a));
        int current_sum, largest_sum = 0, ls_index = 0, le_index = 0;
        for (int i = 0; i < a.length; i++) {
            current_sum = 0;
            for (int j = i; j < a.length; j++) {
                current_sum = current_sum + a[j];
                if (current_sum > largest_sum) {
                    largest_sum = current_sum;
                    ls_index = i;
                    le_index = j;
                }
            }
        }
        System.out.println("Largest contiguous subarray # " + largest_sum);
        System.out.println("Start index #" + ls_index);
        System.out.println("End index #" + le_index);

    }

    public static void main(String[] args) {

        int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        maxSubArray(a);

        System.out.println("--");
        int[] b = {1, -4, 3, -4};
        maxSubArray(b);

        System.out.println("--");
        int[] c = {-7, 1, 21, -7, -8, 22, 1, -2, 10, 10, -3, 26, -1, -7, 4, 3, 3, 6, -2, -5};// Utils.getArrayRandomPositivesAndNegatives(20, 30, 10);
        maxSubArray(c);
        System.out.println("--");
    }
}
