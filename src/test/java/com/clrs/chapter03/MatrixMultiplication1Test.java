package com.clrs.chapter03;

import com.clrs.Utils;
import org.junit.Before;
import org.junit.Test;

import javax.rmi.CORBA.Util;

import static org.junit.Assert.*;

import java.util.Arrays;

public class MatrixMultiplication1Test {
    private MatrixMultiplication1 matrixMultiplication1;

    @Before
    public void before() {
        matrixMultiplication1 = new MatrixMultiplication1();
    }

    @Test
    public void testMultiplySquareMatrices() {
        int[][] a = {{1, 3}, {7, 5}};
        int[][] b = {{6, 8}, {4, 2}};
        int[][] c = matrixMultiplication1.multiplySquareMatrices(a, b);
        System.out.println("Resultant matrix #");
        Utils.printMatrix(c);
        assertEquals(2, c.length);
        assertEquals(18, c[0][0]);
        assertEquals(14, c[0][1]);
        assertEquals(62, c[1][0]);
        assertEquals(66, c[1][1]);
    }
}
