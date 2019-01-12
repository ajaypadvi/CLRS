package com.clrs.chapter02;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class InsertionSortTest {
    private static Logger logger = LoggerFactory.getLogger(InsertionSortTest.class.getName());
    private static final Random random = new Random(10);

    @Test
    public void sortPositiveIntegersArray() {
        int[] input = {5, 2, 4, 6, 1, 3};
        logger.info("Before Sorting InsertionSortTest.sortPositiveIntegersArray() {}", Arrays.toString(input));
        InsertionSort.sort(input);
        logger.info("After sorting InsertionSortTest.sortPositiveIntegersArray() {}", Arrays.toString(input));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, input);
    }

    @Test
    public void sortNegativeIntegersArray() {
        int[] input = {-5, -2, -4, -6, -1, -3};
        logger.info("Before Sorting InsertionSortTest.sortNegativeIntegersArray() {}", Arrays.toString(input));
        InsertionSort.sort(input);
        logger.info("After sorting InsertionSortTest.sortNegativeIntegersArray() {}", Arrays.toString(input));
        Assert.assertArrayEquals(new int[]{-6, -5, -4, -3, -2, -1}, input);
    }

    @Test
    public void sortPositiveAndNegativeIntegersArray() {
        int[] input = {5, 2, 4, -6, 1, -3};
        logger.info("Before Sorting InsertionSortTest.sortPositiveAndNegativeIntegersArray() {}", Arrays.toString(input));
        InsertionSort.sort(input);
        logger.info("After sorting InsertionSortTest.sortPositiveAndNegativeIntegersArray() {}", Arrays.toString(input));
        Assert.assertArrayEquals(new int[]{-6, -3, 1, 2, 4, 5}, input);
    }

    @Test
    public void sortArrayFilledWithRandomIntegers() {
        int[] input = new int[6];
        for (int i = 0; i < 6; i++) {
            input[i] = random.nextInt(10);
        }
        logger.info("Before sorting InsertionSortTest.sortArrayFilledWithRandomIntegers() {}", Arrays.toString(input));
        InsertionSort.sort(input);
        logger.info("After sorting InsertionSortTest.sortArrayFilledWithRandomIntegers() {}", Arrays.toString(input));
        Assert.assertTrue(isSorted(input));
    }

    public static boolean isSorted(int[] array) {
        return IntStream.range(0, array.length - 1).allMatch(i -> array[i] <= array[i + 1]);
    }
}
