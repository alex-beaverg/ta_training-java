package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        int[] newArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                array[i] = newArray[array.length - 1];
            } else {
                array[i] = newArray[i - 1];
            }
        }
        System.out.println(Arrays.toString(array));
    }

    static void cycleSwap(int[] array, int shift) {
        int[] newArray = Arrays.copyOf(array, array.length);
        if (shift == array.length) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = 0; i < array.length; i++) {
                if (i < shift) {
                    array[i] = newArray[array.length - shift + i];
                } else {
                    array[i] = newArray[i - shift];
                }
            }
            }
        System.out.println(Arrays.toString(array));
    }
}
