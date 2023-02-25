package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.sql.Array;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int number = Integer.valueOf(scan.nextLine());
        if (number == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else if (number < 0) {
            System.out.println("Seriously? Why so negative?");
        } else {
            String[] names = new String[number];
            for (int i = 0; i < number; i++) {
                String name = scan.nextLine();
                names[i] = name;
            }
            for (int i = 0; i < number; i++) {
                System.out.println("Hello, " + names[i]);
            }
        }
    }
}
