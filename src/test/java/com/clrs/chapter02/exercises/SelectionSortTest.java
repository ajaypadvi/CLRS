package com.clrs.chapter02.exercises;

import com.sun.org.apache.bcel.internal.generic.Select;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class SelectionSortTest {
    private static Logger logger = LoggerFactory.getLogger(SelectionSortTest.class.getName());
    private static final Random random = new Random(10);

    @Test
    public void sortPositiveIntegersArray() {
        int[] input = {5, 2, 4, 6, 1, 3};
        logger.info("Before Sorting SelectionSortTest.sortPositiveIntegersArray() {}", Arrays.toString(input));
        SelectionSort.sort(input);
        logger.info("After sorting SelectionSortTest.sortPositiveIntegersArray() {}", Arrays.toString(input));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, input);
    }

    @Test
    public void sortNegativeIntegersArray() {
        int[] input = {-5, -2, -4, -6, -1, -3};
        logger.info("Before Sorting SelectionSortTest.sortNegativeIntegersArray() {}", Arrays.toString(input));
        SelectionSort.sort(input);
        logger.info("After sorting SelectionSortTest.sortNegativeIntegersArray() {}", Arrays.toString(input));
        Assert.assertArrayEquals(new int[]{-6, -5, -4, -3, -2, -1}, input);
    }

    @Test
    public void sortPositiveAndNegativeIntegersArray() {
        int[] input = {5, 2, 4, -6, 1, -3};
        logger.info("Before Sorting SelectionSortTest.sortPositiveAndNegativeIntegersArray() {}", Arrays.toString(input));
        SelectionSort.sort(input);
        logger.info("After sorting SelectionSortTest.sortPositiveAndNegativeIntegersArray() {}", Arrays.toString(input));
        Assert.assertArrayEquals(new int[]{-6, -3, 1, 2, 4, 5}, input);
    }

    @Test
    public void sortArrayFilledWithRandomIntegers() {
        int[] input = new int[6];
        for (int i = 0; i < 6; i++) {
            input[i] = random.nextInt(10);
        }
        logger.info("Before sorting SelectionSortTest.sortArrayFilledWithRandomIntegers() {}", Arrays.toString(input));
        SelectionSort.sort(input);
        logger.info("After sorting SelectionSortTest.sortArrayFilledWithRandomIntegers() {}", Arrays.toString(input));
        Assert.assertTrue(isSorted(input));
    }

    public static boolean isSorted(int[] array) {
        return IntStream.range(0, array.length - 1).allMatch(i -> array[i] <= array[i + 1]);
    }
}
