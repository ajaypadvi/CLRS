package com.clrs.chapter03;

/**
 * Using strassen's approach which runs in Big O(n^log7) time complexity
 * to multiply square matrices
 * <p>
 * This method partitions the original array by creating new arrays and then copying contents of original array into it
 * This can be also be done using another approach of partition where in we do not create new arrays instead,
 * we use original array to store the elements of partition by keeping an account of indices
 */
public class MatrixMultiplication3 {


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

            //Fill values inside elements of partition matrices created above
            divide(a, A11, 0, 0);
            divide(a, A12, 0, n / 2);
            divide(a, A21, n / 2, 0);
            divide(a, A22, n / 2, n / 2);

            divide(b, B11, 0, 0);
            divide(b, B12, 0, n / 2);
            divide(b, B21, n / 2, 0);
            divide(b, B22, n / 2, n / 2);


            //Create 10 matrices as per strassen's guidlines

            int[][] S1 = subtract(B12, B22);
            int[][] S2 = add(A11, A12);
            int[][] S3 = add(A21, A22);
            int[][] S4 = subtract(B21, B11);
            int[][] S5 = add(A11, A22);
            int[][] S6 = add(B11, B22);
            int[][] S7 = subtract(A12, A22);
            int[][] S8 = add(B21, B22);
            int[][] S9 = subtract(A11, A21);
            int[][] S10 = add(B11, B12);

            //Conquer

            int[][] P1 = multiply(A11, S1);
            int[][] P2 = multiply(S2, B22);
            int[][] P3 = multiply(S3, B11);
            int[][] P4 = multiply(A22, S4);
            int[][] P5 = multiply(S5, S6);
            int[][] P6 = multiply(S7, S8);
            int[][] P7 = multiply(S9, S10);

            int[][] C11 = add(subtract(add(P5, P4), P2), P6);
            int[][] C12 = add(P1, P2);
            int[][] C21 = add(P3, P4);
            int[][] C22 = subtract(subtract(add(P5, P1), P3), P7);


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

    private static int[][] add(int[][] a, int[][] b) {
        int n = a.length;
        int result[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    private static int[][] subtract(int[][] a, int[][] b) {
        int n = a.length;
        int result[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = a[i][j] - b[i][j];
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

