package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public int getDegree() {
        return degrees;
    }

    public static Direction ofDegrees(int degrees) {
        for (Direction direction : Direction.values()) {
            while (degrees < 0) {
                degrees += 360;
            }
            while (degrees >= 360) {
                degrees -= 360;
            }
            if (direction.getDegree() == degrees) {
                return direction;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        for (Direction direction : Direction.values()) {
            while (degrees < 0) {
                degrees += 360;
            }
            while (degrees >= 360) {
                degrees -= 360;
            }
            if (degrees - direction.getDegree() < 22) {
                return direction;
            }
        }
        return null;
    }

    public Direction opposite() {
        int oppDegrees = degrees + 180;
        for (Direction direction : Direction.values()) {
            while (oppDegrees < 0) {
                oppDegrees += 360;
            }
            while (oppDegrees >= 360) {
                oppDegrees -= 360;
            }
            if (direction.getDegree() == oppDegrees) {
                return direction;
            }
        }
        return null;
    }

    public int differenceDegreesTo(Direction direction) {
        if (this.degrees > direction.degrees) {
            if (this.degrees - direction.degrees > 180) {
                return 360 - this.degrees - direction.degrees;
            } else {
                return this.degrees - direction.degrees;
            }
        }
        else {
            if (direction.degrees - this.degrees > 180) {
                return 360 - direction.degrees - this.degrees;
            } else {
                return direction.degrees - this.degrees;
            }
        }
    }
}
