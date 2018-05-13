package com.clrs.chapter01;

public class Exercise123 {
    public static void main(String[] args) {
        int n = 2;
        while (100 * n * n > Math.pow(2, n)) {
            n++;
        }
        System.out.println(n);
    }
}
