package com.clrs.chapter03;

import java.util.Arrays;

/**
 * Using Brute Force method
 * Big O (n^2)
 */
public class MaxSumContiguousSubarray2 {
    public int maxSubArray(int[] a) {
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
        return largest_sum;
    }
}
