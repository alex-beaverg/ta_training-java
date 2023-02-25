package com.epam.rd.autotasks;

import java.math.BigInteger;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        String zeros = "0000000000000000000000000000000000000000000000000000000000000000";
        char[] mapOfShips;
        int a = 0, b = 0;

        String shotsMap = "";
        char[] mapOfShots;
        String str = Long.toBinaryString(shots);
        mapOfShots = (zeros.substring(str.length()) + str).toCharArray();

        String value = Long.toBinaryString(ships);
        mapOfShips = (zeros.substring(value.length()) + value).toCharArray();
        for (int i = 65; i < 73; i++) {
            if(shot.charAt(0) == i) a = i - 65;
        }
        for (int i = 49; i < 57; i++) {
            if(shot.charAt(1) == i) b = (i - 49) * 8;
        }
        for (int i = 0; i < 64; i++) {
            if (i == a + b) mapOfShots[i] = '1';
            else if (mapOfShots[i] != '1') mapOfShots[i] = '0';
        }

        for (int i = 0; i < 64; i++) {
            shotsMap += mapOfShots[i];
        }
        BigInteger bigInteger = new BigInteger(shotsMap, 2);
        shots = bigInteger.longValue();

        return mapOfShips[a + b] == '1';
    }

    public String state() {
        char[] mapOfShips;
        String zeros = "0000000000000000000000000000000000000000000000000000000000000000";

        char[] mapOfShots0;
        String str = Long.toBinaryString(shots);
        mapOfShots0 = (zeros.substring(str.length()) + str).toCharArray();

        char[] mapOfResult = new char[64];
        String result = "";
        String value = Long.toBinaryString(ships);
        mapOfShips = (zeros.substring(value.length()) + value).toCharArray();
        for (int i = 0; i < 64; i++) {
            if (mapOfShips[i] == '1' && mapOfShots0[i] == '1') mapOfResult[i] = '☒';
            else if (mapOfShips[i] == '0' && mapOfShots0[i] == '0') mapOfResult[i] = '.';
            else if (mapOfShips[i] == '1' && mapOfShots0[i] == '0') mapOfResult[i] = '☐';
            else mapOfResult[i] = '×';
        }
        for (int i = 1; i < 65; i++) {
            result += mapOfResult[i - 1];
            if (i % 8 == 0) result += "\n";
        }
        return result;
    }
}
