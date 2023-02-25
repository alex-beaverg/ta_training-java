package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int counter = 0;
        int resultSum = 0;
        while (number != 0) {
            counter++;
            resultSum += number;
            number = scanner.nextInt();
        }
        System.out.println(resultSum / counter);

    }

}