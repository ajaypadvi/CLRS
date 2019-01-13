package com.clrs.chapter02.exercises;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise_2_3_7_FindSumTest {
    private static final Logger logger = LoggerFactory.getLogger(Exercise_2_3_7_FindSum.class);
    private static int[] input = new int[]{2, 4, 5, 7, 1, 2, 3, 6};

    @Test
    public void findFirstPairOfSum() {
        int[] output = Exercise_2_3_7_FindSum.findFirstPairOfSum(input, 13);
        Assert.assertArrayEquals(new int[]{6, 7}, output);

        output = Exercise_2_3_7_FindSum.findFirstPairOfSum(input, 19);
        Assert.assertArrayEquals(new int[]{0, 0}, output);
    }

    @Test
    public void findAnExistenceOfSuchPairUsingBinarySearch() {
        boolean found = Exercise_2_3_7_FindSum.findAnExistenceOfSuchPairUsingBinarySearch(input, 13);
        Assert.assertTrue(found);
        found = Exercise_2_3_7_FindSum.findAnExistenceOfSuchPairUsingBinarySearch(input, 19);
        Assert.assertFalse(found);
    }
}
