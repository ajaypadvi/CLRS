package com.clrs.chapter03;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MaxSumContiguousSubarray3Test {
    private MaxSumContiguousSubarray3 maxSumContiguousSubarray3;

    @Before
    public void setUp() {
        maxSumContiguousSubarray3 = new MaxSumContiguousSubarray3();
    }

    @Test
    public void findMaximumSubarray_test1() {
        int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        MaxSumContiguousSubarray3.Tuple tuple = maxSumContiguousSubarray3.findMaximumSubarray(a, 0, a.length - 1);
        assertEquals(43, tuple.getSum());
        assertEquals(7, tuple.getLeft());
        assertEquals(10, tuple.getRight());
    }

    @Test
    public void findMaximumSubarray_test2() {
        int[] a = {1, -4, 3, -4};
        MaxSumContiguousSubarray3.Tuple tuple = maxSumContiguousSubarray3.findMaximumSubarray(a, 0, a.length - 1);
        assertEquals(3, tuple.getSum());
        assertEquals(2, tuple.getLeft());
        assertEquals(2, tuple.getRight());
    }


    @Test
    public void findMaximumSubarray_test3() {
        int[] a = new int[]{-7, 1, 21, -7, -8, 22, 1, -2, 10, 10, -3, 26, -1, -7, 4, 3, 3, 6, -2, -5};
        MaxSumContiguousSubarray3.Tuple tuple = maxSumContiguousSubarray3.findMaximumSubarray(a, 0, a.length - 1);
        assertEquals(79, tuple.getSum());
        assertEquals(1, tuple.getLeft());
        assertEquals(17, tuple.getRight());
    }
}
