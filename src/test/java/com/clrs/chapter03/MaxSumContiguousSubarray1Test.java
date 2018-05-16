package com.clrs.chapter03;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxSumContiguousSubarray1Test {
    private MaxSumContiguousSubarray1 maxSumContiguousSubarray1;

    @Before
    public void setUp() {
        maxSumContiguousSubarray1 = new MaxSumContiguousSubarray1();
    }

    @Test
    public void maxSubArray1_test1() {
        int largest_sum = maxSumContiguousSubarray1.maxSubArray1(new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7});
        assertEquals(43, largest_sum);
    }

    @Test
    public void maxSubArray1_test2() {
        int largest_sum = maxSumContiguousSubarray1.maxSubArray1(new int[]{1, -4, 3, -4});
        assertEquals(3, largest_sum);
    }

    @Test
    public void maxSubArray1_test3() {
        int largest_sum = maxSumContiguousSubarray1.maxSubArray1(new int[]{-7, 1, 21, -7, -8, 22, 1, -2, 10, 10, -3, 26, -1, -7, 4, 3, 3, 6, -2, -5});
        assertEquals(79, largest_sum);
    }

    @Test
    public void maxSubArray2_test1() {
        int largest_sum = maxSumContiguousSubarray1.maxSubArray1(new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7});
        assertEquals(43, largest_sum);
    }

    @Test
    public void maxSubArray2_test2() {
        int largest_sum = maxSumContiguousSubarray1.maxSubArray1(new int[]{1, -4, 3, -4});
        assertEquals(3, largest_sum);
    }

    @Test
    public void maxSubArray2_test3() {
        int largest_sum = maxSumContiguousSubarray1.maxSubArray1(new int[]{-7, 1, 21, -7, -8, 22, 1, -2, 10, 10, -3, 26, -1, -7, 4, 3, 3, 6, -2, -5});
        assertEquals(79, largest_sum);
    }

    @Test
    public void maxSubArray3_test1() {
        int largest_sum = maxSumContiguousSubarray1.maxSubArray1(new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7});
        assertEquals(43, largest_sum);
    }

    @Test
    public void maxSubArray3_test2() {
        int largest_sum = maxSumContiguousSubarray1.maxSubArray1(new int[]{1, -4, 3, -4});
        assertEquals(3, largest_sum);
    }

    @Test
    public void maxSubArray3_test3() {
        int largest_sum = maxSumContiguousSubarray1.maxSubArray1(new int[]{-7, 1, 21, -7, -8, 22, 1, -2, 10, 10, -3, 26, -1, -7, 4, 3, 3, 6, -2, -5});
        assertEquals(79, largest_sum);
    }
}
