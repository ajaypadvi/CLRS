package com.clrs.chapter07;

import com.clrs.Utils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class QuickSort1Test {

    private QuickSort1 quickSort1;

    @Before
    public void before() {
        quickSort1 = new QuickSort1();
    }

    @Test
    public void testQuickSort1() {
        int a[] = {2, 8, 7, 1, 3, 5, 6, 4};
        quickSort1.quickSort(a, 0, a.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, a);
    }

    @Test
    public void testQuickSort2() {
        int a[] = {13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11};
        quickSort1.quickSort(a, 0, a.length - 1);
        assertArrayEquals(new int[]{2, 4, 5, 6, 7, 8, 9, 11, 12, 13, 19, 21}, a);
    }

    @Test
    public void testQuickSort3() {
        int[] a = Utils.getArrayRandomPositives(20, 10);
        quickSort1.quickSort(a, 0, a.length - 1);
        assertTrue(Utils.testSort(a, true));
    }
}
