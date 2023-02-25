package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int h = scan.nextInt();
        int result = 0;
        int days = 0;
        if (a <= b && a < h) {
            System.out.println("Impossible");
        } else {
            while (result < h) {
                result += a;
                if (result < h) {
                    result -= b;
                    days++;
                } else if (result >= h) {
                    days++;
                }
            }
            System.out.println(days);
        }

    }
}
