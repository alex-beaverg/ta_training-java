package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private final Point a, b, c;
    private double x1, y1, x2, y2, x3, y3;
    private double ab, bc, ca;
    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
        this.c = c;
        calculateLengths();
        if ((x3 - x1) * (y2 - y1) - (x2 - x1) * (y3 - y1) == 0) throw new IllegalArgumentException();
    }
    @Override
    public double area() {
        double sinAbBc = Math.sqrt(1 -
                Math.pow((Math.pow(ab, 2) + Math.pow(bc, 2) - Math.pow(ca, 2)) / (2 * ab * bc), 2));
        return 0.5 * ab * bc * sinAbBc;
    }
    @Override
    public String pointsToString() {
        return "(" + x1 + "," + y1 + ")" + "(" + x2 + "," + y2 + ")" + "(" + x3 + "," + y3 + ")";
    }
    @Override
    public Point leftmostPoint() {
        double minX = Math.min(Math.min(x1,x2), x3);
        if (minX == x1) return a;
        else if(minX == x2) return b;
        else return c;
    }
    @Override
    public void calculateLengths() {
        x1 = a.getX();
        y1 = a.getY();
        x2 = b.getX();
        y2 = b.getY();
        x3 = c.getX();
        y3 = c.getY();
        ab = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1,2));
        bc = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2,2));
        ca = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3,2));
    }

    @Override
    public Point centroid() {
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
            y = k2 * x + b2;
        } else if (mAcX == x2) {
            x = x2;
            y = k1 * x + b1;
        } else {
            x = (b1 - b2) / (k2 - k1);
            y = k2 * x + b2;
        }
        return new Point(x, y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        try {
            Triangle triangle = (Triangle) figure;
            double xa1 = ((double) Math.round(this.a.getX() * 10)) / 10;
            double xa2 = ((double) Math.round(triangle.a.getX() * 10)) / 10;
            double ya1 = ((double) Math.round(this.a.getY() * 10)) / 10;
            double ya2 = ((double) Math.round(triangle.a.getY() * 10)) / 10;
            double xb1 = ((double) Math.round(this.b.getX() * 10)) / 10;
            double xb2 = ((double) Math.round(triangle.b.getX() * 10)) / 10;
            double yb1 = ((double) Math.round(this.b.getY() * 10)) / 10;
            double yb2 = ((double) Math.round(triangle.b.getY() * 10)) / 10;
            double xc1 = ((double) Math.round(this.c.getX() * 10)) / 10;
            double xc2 = ((double) Math.round(triangle.c.getX() * 10)) / 10;
            double yc1 = ((double) Math.round(this.c.getY() * 10)) / 10;
            double yc2 = ((double) Math.round(triangle.c.getY() * 10)) / 10;
            return xa1 == xa2 && ya1 == ya2 && xb1 == xb2 && yb1 == yb2 && xc1 == xc2 && yc1 == yc2;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
