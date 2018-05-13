package com.clrs;

import java.util.Random;

public class Utils {

    public static int[] getArrayRandom(int size, int precision) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(precision);
        }
        return array;
    }
}
