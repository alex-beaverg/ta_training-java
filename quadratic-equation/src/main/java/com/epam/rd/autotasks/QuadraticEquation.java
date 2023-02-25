package com.epam.rd.autotasks;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double result1, result2;

        double discriminant = Math.pow(b,2) - 4 * a * c;
        if (discriminant == 0) {
            result1 = (- b) / (2 * a);
            System.out.println(result1);
        } else if (discriminant > 0) {
            result1 = ((- b) + Math.sqrt(discriminant)) / (2 * a);
            result2 = ((- b) - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(result1 + " " + result2);
        } else {
            System.out.println("no roots");
        }
    }
}