package com.clrs.chapter03;

import com.clrs.Utils;

import java.util.Arrays;

/**
 * Using kadan's algorithm
 * Worst case Big-O(n)
 * Average case Theta(n)
 */
public class MaxSumContiguousSubarray1 {
    private static void maxSubArray(int[] a) {
        System.out.println(Arrays.toString(a));
        int current_sum = 0, largest_sum = 0;
        int cs_index = 0;//current start index
        int ls_index = 0, le_index = 0; //largest start and end indices
        for (int i = 0; i < a.length; i++) {
            current_sum = current_sum + a[i];
            if (current_sum < 0) {
                current_sum = 0;
                cs_index = i + 1;
            } else if (current_sum > largest_sum) {
                largest_sum = current_sum;
                ls_index = cs_index;
                le_index = i;
            }
        }
        System.out.println("largest sum # " + largest_sum);
        System.out.println("start index # " + ls_index);
        System.out.println("end index # " + le_index);
    }

    private static void maxSubArraySum(int a[], int size) {
        int max_so_far = Integer.MIN_VALUE,
                max_ending_here = 0, start = 0,
                end = 0, s = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here += a[i];

            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        System.out.println("Maximum contiguous sum is "
                + max_so_far);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
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

        maxSubArraySum(c, c.length);


    }

}
