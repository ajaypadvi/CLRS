package com.clrs.chapter02.exercises;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinarySearchTest {
    private static final Logger logger = LoggerFactory.getLogger(BinarySearchTest.class.getName());
    private static final int[] input = new int[]{1, 3, 5, 7, 9, 2, 30, 32};

    @Test
    public void iterativeBinarySearch() {
        Assert.assertEquals(6, BinarySearch.iterativeBinarySearch(input, 30));
        Assert.assertEquals(7, BinarySearch.iterativeBinarySearch(input, 32));
        Assert.assertEquals(-1, BinarySearch.iterativeBinarySearch(input, 44));
    }

    @Test
    public void recursiveBinarySearch() {
        Assert.assertEquals(6, BinarySearch.recursiveBinarySearch(input, 0, 7, 30));
        Assert.assertEquals(7, BinarySearch.recursiveBinarySearch(input, 0, 7, 32));
        Assert.assertEquals(-1, BinarySearch.recursiveBinarySearch(input, 0, 7, 44));
    }
}
