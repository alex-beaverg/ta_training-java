package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        int secondsRemain = seconds % 60;
        int integerMinutes = seconds / 60;
        int minutesRemain = integerMinutes % 60;
        int hours = integerMinutes / 60;
        int hoursRemain = hours >= 24 ? hours % 24 : hours;

        String minutesStr = minutesRemain < 10 ? "0" + minutesRemain : String.valueOf(minutesRemain);
        String secondsStr = secondsRemain < 10 ? "0" + secondsRemain : String.valueOf(secondsRemain);
        System.out.println(hoursRemain + ":" + minutesStr + ":" + secondsStr);
    }
}
