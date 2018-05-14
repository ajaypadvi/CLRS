package com.clrs.chapter02;

public class Problem_2_4 {
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
    public static void inversionPairsImproved(int[] a) {

    }

    public static void main(String[] args) {
        int[] a = {2, 3, 8, 6, 1};
        inversionPairs(a);

    }
}
