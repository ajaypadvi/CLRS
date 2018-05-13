package com.clrs.chapter02;

import java.util.Arrays;

/**
 *
 */
public class Exercise_2_3_7 {

    public static int[] findFirstPairOfSum(int[] a, int sum) {
        MergeSortWithoutSentinel.mergeSort(a, 0, a.length - 1);
        int[] result = new int[2];
        System.out.println("Sorted array #" + Arrays.toString(a));
        int i = 0;
        int j = a.length - 1;

        int currentSum;
        while (i < j) {
            currentSum = a[i] + a[j];
            if (currentSum == sum) {
                System.out.println(a[i] + "," + a[j]);
                result[0] = a[i];
                result[1] = a[j];
                break;
            } else if (currentSum > sum) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 5, 7, 1, 2, 3, 6};
        System.out.println(Arrays.toString(findFirstPairOfSum(a, 14)));
    }


}
