package com.clrs;

import java.util.Arrays;
import java.util.Random;

public class Utils {

    public static int[] getArrayRandomPositives(int size, int precision) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(precision);
        }
        return array;
    }

    public static int[] getArrayRandomPositivesAndNegatives(int size, int max, int min) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max + 1 + min) - min;
        }
        return array;
    }

    public static boolean testSort(int[] a, boolean increasing) {
        for (int i = a.length - 1; i > 0; i--) {

            if ((increasing && a[i] < a[i - 1])) {
                return false;
            } else if (!increasing && a[i] > a[i - 1]) {

            }
        }
        return true;
    }

    public static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
