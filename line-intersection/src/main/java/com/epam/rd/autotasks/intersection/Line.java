package com.epam.rd.autotasks.intersection;

public class Line {
    int k;
    int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;

    }

    public Point intersection(Line other) {

        int a1 = other.getK();
        int b1 = other.getB();
        int a2 = this.getK();
        int b2 = this.getB();

        if (a1 == a2 && b1 == b2 || a1 == a2) {
            return null;
        }

        int x = (b2 - b1) / (a1 - a2);
        int y = ((a1 * (b2 - b1)) / (a1 - a2)) + b1;

        return new Point(x, y);
    }

    public int getK() {
        return k;
    }

    public int getB() {
        return b;
    }
}
