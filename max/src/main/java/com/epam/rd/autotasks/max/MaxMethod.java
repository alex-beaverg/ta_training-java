package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] values) {
        int firstNumber = values[0];
        for (int elem : values) {
            if (firstNumber < elem) {
                firstNumber = elem;
            }
        }
        return firstNumber;
    }
}
