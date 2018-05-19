package com.clrs.chapter03;

import com.clrs.Utils;

/**
 * It shows the multiplication of two matrices using brute force algorithm
 * this runs in big O(n^3) time
 */
public class MatrixMultiplication1 {

    public int[][] multiplySquareMatrices(int[][] a, int[][] b) {
        System.out.println("First Matrix #a");
        Utils.printMatrix(a);
        System.out.println("Second Matrix #b");
        Utils.printMatrix(b);

        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    c[i][j] = c[i][j] + (a[i][k] * b[k][j]);
                }
            }
        }
        return c;
    }
}
