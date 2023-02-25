package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = scanner.nextInt();
        int numberOfOnePizzaPieces = scanner.nextInt();
        int countOfPizzas = 1;
        while (countOfPizzas * numberOfOnePizzaPieces % numberOfPeople != 0) {
            countOfPizzas++;
        }
        System.out.println(countOfPizzas);
    }
}
