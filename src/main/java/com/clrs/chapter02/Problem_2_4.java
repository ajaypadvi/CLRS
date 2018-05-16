package com.clrs.chapter02;

import com.clrs.Utils;

import java.util.Arrays;

public class Problem_2_4 {
    private static int max = Integer.MAX_VALUE;

    /**
     * Solution which finds inversion pairs in o(n2)
     * Brute force algorithm
     *
     * @param a
     */
    public static void inversionPairs(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    System.out.println("[" + i + "," + j + "]");
                }
            }
        }
    }

    /**
     * An improved solution which finds inversion pairs in o(n2) using merge sort technique
     *
     * @param a
     */
    public static int invPairsRecursive(int[] a, int p, int r) {
        int q;
        int inversions = 0;
        if (p < r) {
            q = (p + r) / 2;
            inversions = invPairsRecursive(a, p, q);
            inversions += invPairsRecursive(a, q + 1, r);
            inversions += mergeAndCountInvPairs(a, p, q, r);
        }
        return inversions;
    }

    public static int mergeAndCountInvPairs(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];

        //assigning sentinels
        left[left.length - 1] = max;
        right[right.length - 1] = max;

        int i;
        int j;
        for (i = 0; i < n1; i++) {
            left[i] = a[p + i];
        }

        for (j = 0; j < n2; j++) {
            right[j] = a[q + j + 1];
        }

        i = 0;
        j = 0;
        int inversions = 0;
        for (int k = p; k <= r; k++) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
                inversions += (left.length - 1) - i;//extra -1 is to take into account the sentinel value
            }
        }
        return inversions;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 2, 4, 6};
        System.out.println(Arrays.toString(a));
        inversionPairs(a);
        int inversions = invPairsRecursive(a, 0, a.length - 1);
        System.out.println(inversions);

        System.out.println("--");

        int[] randomArray = Utils.getArrayRandomPositives(20, 10);
        System.out.println(Arrays.toString(randomArray));
        inversionPairs(randomArray);
        inversions = invPairsRecursive(randomArray, 0, randomArray.length - 1);
        System.out.println(inversions);

    }
}
