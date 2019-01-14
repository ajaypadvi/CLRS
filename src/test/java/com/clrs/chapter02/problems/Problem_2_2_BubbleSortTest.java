package com.clrs.chapter02.problems;

import com.clrs.chapter02.InsertionSort;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Problem_2_2_BubbleSortTest {

    private static Logger logger = LoggerFactory.getLogger(Problem_2_2_BubbleSortTest.class.getName());
    private static final Random random = new Random(10);

    @Test
    public void sortPositiveIntegersArray() {
        int[] input = {5, 2, 4, 6, 1, 3};
        logger.info("Before Sorting Problem_2_2_BubbleSortTest.sortPositiveIntegersArray() {}", Arrays.toString(input));
        Problem_2_2_BubbleSort.sort(input);
        logger.info("After sorting Problem_2_2_BubbleSortTest.sortPositiveIntegersArray() {}", Arrays.toString(input));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, input);
    }

    @Test
    public void sortNegativeIntegersArray() {
        int[] input = {-5, -2, -4, -6, -1, -3};
        logger.info("Before Sorting Problem_2_2_BubbleSortTest.sortNegativeIntegersArray() {}", Arrays.toString(input));
        Problem_2_2_BubbleSort.sort(input);
        logger.info("After sorting Problem_2_2_BubbleSortTest.sortNegativeIntegersArray() {}", Arrays.toString(input));
        Assert.assertArrayEquals(new int[]{-6, -5, -4, -3, -2, -1}, input);
    }

    @Test
    public void sortPositiveAndNegativeIntegersArray() {
        int[] input = {5, 2, 4, -6, 1, -3};
        logger.info("Before Sorting Problem_2_2_BubbleSortTest.sortPositiveAndNegativeIntegersArray() {}", Arrays.toString(input));
        Problem_2_2_BubbleSort.sort(input);
        logger.info("After sorting Problem_2_2_BubbleSortTest.sortPositiveAndNegativeIntegersArray() {}", Arrays.toString(input));
        Assert.assertArrayEquals(new int[]{-6, -3, 1, 2, 4, 5}, input);
    }

    @Test
    public void sortArrayFilledWithRandomIntegers() {
        int[] input = new int[6];
        for (int i = 0; i < 6; i++) {
            input[i] = random.nextInt(10);
        }
        logger.info("Before sorting Problem_2_2_BubbleSortTest.sortArrayFilledWithRandomIntegers() {}", Arrays.toString(input));
        Problem_2_2_BubbleSort.sort(input);
        logger.info("After sorting Problem_2_2_BubbleSortTest.sortArrayFilledWithRandomIntegers() {}", Arrays.toString(input));
        Assert.assertTrue(isSorted(input));
    }

    @Test
    public void alreadySortedArray() {
        int[] input = {1, 2, 3, 4, 5, 6};
        logger.info("Before Sorting Problem_2_2_BubbleSortTest.alreadySortedArray() {}", Arrays.toString(input));
        Problem_2_2_BubbleSort.sort(input);
        logger.info("After sorting Problem_2_2_BubbleSortTest.alreadySortedArray() {}", Arrays.toString(input));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, input);
    }

    public static boolean isSorted(int[] array) {
        return IntStream.range(0, array.length - 1).allMatch(i -> array[i] <= array[i + 1]);
    }
}
