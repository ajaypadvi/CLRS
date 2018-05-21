package com.clrs.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


/**
 * Using kadan's algorithm
 * Worst case Big-O(n)
 * Average case Theta(n)
 */
public class MaxSumContiguousSubarray1 {
    private static Logger LOG = LoggerFactory.getLogger(MaxSumContiguousSubarray1.class);

    public int maxSubArray1(int[] a) {
        LOG.debug(Arrays.toString(a));
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
        LOG.info("largest sum # ", largest_sum);
        LOG.info("start index # ", ls_index);
        LOG.info("end index # ", le_index);

        return largest_sum;
    }

    public int maxSubArray2(int a[], int size) {
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
        return max_so_far;
    }

    public int maxSubArray3(int[] a) {
        System.out.println(Arrays.toString(a));
        int current_sum = 0, largest_sum = 0;
        for (int i = 0; i < a.length; i++) {
            current_sum = Math.max(current_sum, a[i]);
            largest_sum = Math.max(largest_sum, current_sum);
        }
        System.out.println(largest_sum);
        return largest_sum;
    }
}
