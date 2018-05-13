package com.clrs.chapter01;

public class Exercise1_2_2 {

    public static void main(String[] args) {
        int n = 2;
        while (Double.compare(Math.pow(2, (n / 8)), n) < 0) {
            n++;
        }
        System.out.println(n);
    }
}
