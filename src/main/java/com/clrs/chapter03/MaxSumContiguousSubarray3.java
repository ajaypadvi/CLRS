package com.clrs.chapter03;

/**
 * Using divide and conquer algorithm
 * big O(nlogn)
 */
public class MaxSumContiguousSubarray3 {

    private Tuple findMaxCrossingSubarray(int[] a, int low, int mid, int high) {
        int left_sum = Integer.MIN_VALUE;
        int right_sum = Integer.MIN_VALUE;
        int max_left = mid, max_right = mid;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum = sum + a[i];
            if (sum > left_sum) {
                left_sum = sum;
                max_left = i;
            }
        }

        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum = sum + a[j];
            if (sum > right_sum) {
                right_sum = sum;
                max_right = j;
            }
        }
        Tuple tuple = new Tuple(max_left, max_right, left_sum + right_sum);
        return tuple;
    }

    public Tuple findMaximumSubarray(int[] a, int low, int high) {
        Tuple left_tuple, right_tuple, cross_tuple;
        int mid;
        if (low == high) {
            return new Tuple(low, high, a[low]);
        } else {
            mid = ((high - low) / 2) + low;
            left_tuple = findMaximumSubarray(a, low, mid);
            right_tuple = findMaximumSubarray(a, mid + 1, high);
            cross_tuple = findMaxCrossingSubarray(a, low, mid, high);
            if (left_tuple.getSum() > right_tuple.getSum() && left_tuple.getSum() > cross_tuple.getSum()) {
                return left_tuple;
            } else if (right_tuple.getSum() > left_tuple.getSum() && right_tuple.getSum() > cross_tuple.getSum()) {
                return right_tuple;
            } else {
                return cross_tuple;
            }
        }
    }

    public static class Tuple {
        private int left;
        private int right;
        private int sum;

        public Tuple(int left, int right, int sum) {
            this.left = left;
            this.right = right;
            this.sum = sum;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        public int getSum() {
            return sum;
        }
    }
}
