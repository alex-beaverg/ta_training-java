package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalBill = scan.nextInt();
        int number = scan.nextInt();
        if (totalBill < 0) {
            System.out.println("Bill total amount cannot be negative");
        } else if (number <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        } else {
            double result = (double) totalBill / (double) number + ((double) totalBill / (double) number) / 10;
            System.out.println((int) result);
        }

    }
}
