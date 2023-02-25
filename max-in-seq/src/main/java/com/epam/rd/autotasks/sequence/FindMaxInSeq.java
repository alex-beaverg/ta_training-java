package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int firstNumber = number;
        while (number != 0) {
            if (number > firstNumber) {
                firstNumber = number;
            }
            number = scanner.nextInt();
        }

        return firstNumber;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
