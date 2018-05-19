package com.clrs.chapter03;

import com.clrs.Utils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixMultiplication3Test {

    private MatrixMultiplication3 matrixMultiplication3;

    @Before
    public void setUp() {
        matrixMultiplication3 = new MatrixMultiplication3();
    }

    @Test
    public void test_multiply() {
        int[][] a = {{1, 3}, {7, 5}};
        int[][] b = {{6, 8}, {4, 2}};
        int[][] c = matrixMultiplication3.multiply(a, b);
        System.out.println("Resultant matrix #");
        Utils.printMatrix(c);
        assertEquals(2, c.length);
        assertEquals(18, c[0][0]);
        assertEquals(14, c[0][1]);
        assertEquals(62, c[1][0]);
        assertEquals(66, c[1][1]);
    }
}
