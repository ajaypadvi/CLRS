package com.clrs.chapter03;

/**
 * Using divide and conquer approach which runs in Big O(n^3) time complexity
 * to multiply square matrices
 * <p>
 * This method partitions the original array by creating new arrays and then copying contents of original array into it
 * This can be also be done using another approach of partition where in we do not create new arrays instead,
 * we use original array to store the elements of partition by keeping an account of indices
 */
public class MatrixMultiplication2 {

    public int[][] multiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        if (n == 1) {
            c[0][0] = a[0][0] * b[0][0];
        } else {
            //Partition A,B,C by creating new partition arrays and filling them in with original array elements
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];

            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            int[][] C11 = new int[n / 2][n / 2];
            int[][] C12 = new int[n / 2][n / 2];
            int[][] C21 = new int[n / 2][n / 2];
            int[][] C22 = new int[n / 2][n / 2];

            //Fill values inside elements of partition matrices created above
            divide(a, A11, 0, 0);
            divide(a, A12, 0, n / 2);
            divide(a, A21, n / 2, 0);
            divide(a, A22, n / 2, n / 2);

            divide(b, B11, 0, 0);
            divide(b, B12, 0, n / 2);
            divide(b, B21, n / 2, 0);
            divide(b, B22, n / 2, n / 2);

            //Conquer
            addMatrices(C11, multiply(A11, B11), multiply(A12, B21));
            addMatrices(C12, multiply(A11, B12), multiply(A12, B22));
            addMatrices(C21, multiply(A21, B11), multiply(A22, B21));
            addMatrices(C22, multiply(A21, B12), multiply(A22, B22));

            //Combine
            combine(C11, c, 0, 0);
            combine(C12, c, 0, n / 2);
            combine(C21, c, n / 2, 0);
            combine(C22, c, n / 2, n / 2);
        }
        return c;
    }

    private static void divide(int[][] from, int[][] to, int from_row, int from_column) {
        int to_m = to.length;
        int to_n = to[0].length;

        for (int i1 = from_row, i2 = 0; i2 < to_m; i1++, i2++) {
            for (int j1 = from_column, j2 = 0; j2 < to_n; j1++, j2++) {
                to[i2][j2] = from[i1][j1];
            }
        }
    }

    private static int[][] addMatrices(int result[][], int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    private static void combine(int[][] from, int[][] to, int to_row, int to_column) {
        for (int i1 = 0, i2 = to_row; i1 < from.length; i1++) {
            for (int j1 = 0, j2 = to_column; j1 < from.length; j1++) {
                to[i2][j2] = from[i1][j1];
            }
        }
    }
}
