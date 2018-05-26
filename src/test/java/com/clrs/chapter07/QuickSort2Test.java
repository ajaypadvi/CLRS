package com.clrs.chapter07;


import com.clrs.Utils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class QuickSort2Test {

    private QuickSort2 QuickSort2;

    @Before
    public void before() {
        QuickSort2 = new QuickSort2();
    }

    @Test
    public void testQuickSort1() {
        int a[] = {2, 8, 7, 1, 3, 5, 6, 4};
        QuickSort2.quickSort(a, 0, a.length - 1);
        assertArrayEquals(new int[]{8, 7, 6, 5, 4, 3, 2, 1}, a);
    }

    @Test
    public void testQuickSort2() {
        int a[] = {13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11};
        QuickSort2.quickSort(a, 0, a.length - 1);
        assertArrayEquals(new int[]{21, 19, 13, 12, 11, 9, 8, 7, 6, 5, 4, 2}, a);
    }

    @Test
    public void testQuickSort3() {
        int[] a = Utils.getArrayRandomPositives(20, 10);
        QuickSort2.quickSort(a, 0, a.length - 1);
        assertTrue(Utils.testSort(a,false));
    }
}
