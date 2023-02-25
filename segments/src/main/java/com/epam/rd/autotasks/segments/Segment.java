package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    double x1;
    double y1;
    double x2;
    double y2;

    public Segment(Point start, Point end) {
        x1 = start.getX();
        y1 = start.getY();
        x2 = end.getX();
        y2 = end.getY();
        if (x1 == x2 && y1 == y2) {
            throw new IllegalArgumentException();
        }
    }

    double length() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1,2));
    }

    Point middle() {
        return new Point((x2 + x1) / 2, (y2 + y1) / 2);
    }

    Point intersection(Segment another) {
        double x1 = this.x1;
        double y1 = this.y1;
        double x2 = this.x2;
        double y2 = this.y2;
        double m1 = another.x1;
        double n1 = another.y1;
        double m2 = another.x2;
        double n2 = another.y2;

        double v1, v2, v3, v4;
        v1 = (m2 - m1) * (y1 - n1) - (n2 - n1) * (x1 - m1);
        v2 = (m2 - m1) * (y2 - n1) - (n2 - n1) * (x2 - m1);
        v3 = (x2 - x1) * (n1 - y1) - (y2 - y1) * (m1 - x1);
        v4 = (x2 - x1) * (n2 - y1) - (y2 - y1) * (m2 - x1);

        if (v1 * v2 > 0 || v3 * v4 > 0) {
            return null;
        }

        double x, y;

        double k1 = (y1 - y2) / (x1 - x2);
        double b1 = y2 - k1 * x2;
        double k2 = (n1 - n2) / (m1 - m2);
        double b2 = n2 - k2 * m2;

        x = (b1 - b2) / (k2 - k1);
        y = k2 * (b1 - b2) / (k2 - k1) + b2;

        if (k1 == k2 || k1 == k2 && b1 == b2) {
            return null;
        }

        return new Point(x, y);
    }
}
