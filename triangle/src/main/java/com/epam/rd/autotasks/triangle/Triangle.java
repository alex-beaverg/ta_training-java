package com.epam.rd.autotasks.triangle;

class Triangle {
    double x1;
    double y1;
    double x2;
    double y2;
    double x3;
    double y3;
    double ab;
    double bc;
    double ca;

    public Triangle(Point a, Point b, Point c) {
        x1 = a.getX();
        y1 = a.getY();
        x2 = b.getX();
        y2 = b.getY();
        x3 = c.getX();
        y3 = c.getY();

        ab = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1,2));
        bc = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2,2));
        ca = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3,2));

        if (ab + bc <= ca || bc + ca <= ab || ca + ab <= bc) {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        double sinAbBc = Math.sqrt(1 -
                Math.pow((Math.pow(ab, 2) + Math.pow(bc, 2) - Math.pow(ca, 2)) / (2 * ab * bc), 2));
        return 0.5 * ab * bc * sinAbBc;
    }

    public Point centroid(){
        double mAbX = (x1 + x2) / 2;
        double mAbY = (y1 + y2) / 2;
        double mAcX = (x1 + x3) / 2;
        double mAcY = (y1 + y3) / 2;
        double k1, k2, b1, b2;
        double x, y;

        k1 = (mAbY - y3) / (mAbX - x3);
        b1 = y3 - k1 * x3;
        k2 = (mAcY - y2) / (mAcX - x2);
        b2 = y2 - k2 * x2;

        if (mAbX == x3) {
            x = x3;
        } else {
            x = (b1 - b2) / (k2 - k1);
        }
        y = k2 * x + b2;

        return new Point(x, y);
    }
}
