package com.clrs.chapter02.exercises;

import com.clrs.chapter02.MergeSort;

import java.util.Arrays;


public class Exercise_2_3_7_FindSum {

    /**
     * Below method does not basically uses the binary search to find the pair of elements inside an array whose sum is equal to requested value of 'x'
     * It rather uses the different strategy under which you will iterate from frond and back of the sorted array and will decide if such sum exists or not
     *
     * @param a an input array
     * @param x the requested sum value as an input
     * @return resultant array which contains positions of such two element pair if sum==x exists in array
     */
    public static int[] findFirstPairOfSum(int[] a, int x) {
        MergeSort.sort(a, 0, a.length - 1);
        int[] result = new int[2];
        int i = 0;
        int j = a.length - 1;

        int sum;
        while (i < j) {
            sum = a[i] + a[j];
            if (sum == x) {
                result[0] = a[i];
                result[1] = a[j];
                break;
            } else if (sum > x) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }


    /**
     * Below method uses the binary search to find such two elements whose sum is equal to x
     * Let a and b are two such elements a+b=x
     * b=x-a
     * if (x-a) exists for any element in a while iteraing them such pair exists
     * 13-7=6
     * both 6 and 7 exists
     *
     * @param a
     * @param x
     * @return
     */
    public static boolean findAnExistenceOfSuchPairUsingBinarySearch(int[] a, int x) {
        MergeSort.sort(a, 0, a.length - 1);

        for (int i = 0; i < a.length; i++) {
            if (BinarySearch.iterativeBinarySearch(a, x - a[i]) != -1)
                return true;
        }
        return false;
    }

}
