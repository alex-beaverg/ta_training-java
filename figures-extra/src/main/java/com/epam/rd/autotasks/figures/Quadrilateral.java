package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    private final Point a, b, c, d;
    private double x1, y1, x2, y2, x3, y3, x4, y4;
    private double ab, bc, cd, da, ca;
    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if (a == null || b == null || c == null || d == null) throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        calculateLengths();
    }
    @Override
    public double area() {
        double sinAbBc = Math.sqrt(1 -
                Math.pow((Math.pow(ab, 2) + Math.pow(bc, 2) - Math.pow(ca, 2)) / (2 * ab * bc), 2));
        double sinCdDa = Math.sqrt(1 -
                Math.pow((Math.pow(cd, 2) + Math.pow(da, 2) - Math.pow(ca, 2)) / (2 * cd * da), 2));
        return 0.5 * (ab * bc * sinAbBc + cd * da * sinCdDa);
    }
    @Override
    public String pointsToString() {
        return "(" + x1 + "," + y1 + ")" + "(" + x2 + "," + y2 + ")" +
                "(" + x3 + "," + y3 + ")" + "(" + x4 + "," + y4 + ")";
    }
    @Override
    public Point leftmostPoint() {
        double minX = Math.min(Math.min(Math.min(x1,x2), x3), x4);
        if (minX == x1) return a;
        else if(minX == x2) return b;
        else if (minX == x3) return c;
        else return d;
    }
    @Override
    public void calculateLengths() {
        x1 = a.getX();
        y1 = a.getY();
        x2 = b.getX();
        y2 = b.getY();
        x3 = c.getX();
        y3 = c.getY();
        x4 = d.getX();
        y4 = d.getY();
        ab = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1,2));
        bc = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2,2));
        cd = Math.sqrt(Math.pow(x4 - x3, 2) + Math.pow(y4 - y3,2));
        da = Math.sqrt(Math.pow(x1 - x4, 2) + Math.pow(y1 - y4,2));
        ca = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3,2));
        if ((x3 - x1) * (y2 - y1) == (x2 - x1) * (y3 - y1)) throw new IllegalArgumentException();
        if ((x4 - x1) * (y2 - y1) == (x2 - x1) * (y4 - y1)) throw new IllegalArgumentException();
        if ((x1 - x3) * (y4 - y3) == (x4 - x3) * (y1 - y3)) throw new IllegalArgumentException();
        if ((x2 - x3) * (y4 - y3) == (x4 - x3) * (y2 - y3)) throw new IllegalArgumentException();
        double v1, v2, v3, v4;
        v1 = (x3 - x2) * (y1 - y2) - (y3 - y2) * (x1 - x2);
        v2 = (x3 - x2) * (y4 - y2) - (y3 - y2) * (x4 - x2);
        v3 = (x4 - x1) * (y2 - y1) - (y4 - y1) * (x2 - x1);
        v4 = (x4 - x1) * (y3 - y1) - (y4 - y1) * (x3 - x1);
        if (v1 * v2 <= 0 || v3 * v4 <= 0) throw new IllegalArgumentException();
        double w1, w2, w3, w4;
        w1 = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
        w2 = (x2 - x1) * (y4 - y1) - (y2 - y1) * (x4 - x1);
        w3 = (x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3);
        w4 = (x4 - x3) * (y2 - y3) - (y4 - y3) * (x2 - x3);
        if (w1 * w2 <= 0 || w3 * w4 <= 0) throw new IllegalArgumentException();
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
        Point centerABC = new Point(x, y);

        double mCdX = (x3 + x4) / 2;
        double mCdY = (y3 + y4) / 2;
        double mCaX = (x3 + x1) / 2;
        double mCaY = (y3 + y1) / 2;
        k1 = (mCdY - y1) / (mCdX - x1);
        b1 = y1 - k1 * x1;
        k2 = (mCaY - y4) / (mCaX - x4);
        b2 = y4 - k2 * x4;
        if (mCdX == x1) {
            x = x1;
            y = k2 * x + b2;
        } else if (mCaX == x4) {
            x = x4;
            y = k1 * x + b1;
        } else {
            x = (b1 - b2) / (k2 - k1);
            y = k2 * x + b2;
        }
        Point centerCDA = new Point(x, y);

        double mBcX = (x2 + x3) / 2;
        double mBcY = (y2 + y3) / 2;
        double mDcX = (x4 + x3) / 2;
        double mDcY = (y4 + y3) / 2;
        k1 = (mBcY - y4) / (mBcX - x4);
        b1 = y4 - k1 * x4;
        k2 = (mDcY - y2) / (mDcX - x2);
        b2 = y2 - k2 * x2;
        if (mBcX == x4) {
            x = x4;
            y = k2 * x + b2;
        } else if (mDcX == x2) {
            x = x2;
            y = k1 * x + b1;
        } else {
            x = (b1 - b2) / (k2 - k1);
            y = k2 * x + b2;
        }
        Point centerBCD = new Point(x, y);

        double mDaX = (x4 + x1) / 2;
        double mDaY = (y4 + y1) / 2;
        double mBaX = (x2 + x1) / 2;
        double mBaY = (y2 + y1) / 2;
        k1 = (mDaY - y2) / (mDaX - x2);
        b1 = y2 - k1 * x2;
        k2 = (mBaY - y4) / (mBaX - x4);
        b2 = y4 - k2 * x4;
        if (mDaX == x2) {
            x = x2;
            y = k2 * x + b2;
        } else if (mBaX == x4) {
            x = x4;
            y = k1 * x + b1;
        } else {
            x = (b1 - b2) / (k2 - k1);
            y = k2 * x + b2;
        }
        Point centerDAB = new Point(x, y);

        k1 = (centerABC.getY() - centerCDA.getY()) / (centerABC.getX() - centerCDA.getX());
        b1 = centerCDA.getY() - k1 * centerCDA.getX();
        k2 = (centerBCD.getY() - centerDAB.getY()) / (centerBCD.getX() - centerDAB.getX());
        b2 = centerDAB.getY() - k2 * centerDAB.getX();
        if (centerABC.getX() == centerCDA.getX()) {
            x = centerCDA.getX();
            y = k2 * x + b2;
        } else if (centerBCD.getX() == centerDAB.getX()) {
            x = centerDAB.getX();
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
            Quadrilateral quadrilateral = (Quadrilateral) figure;
            double xa1 = ((double) Math.round(this.a.getX() * 10)) / 10;
            double xa2 = ((double) Math.round(quadrilateral.a.getX() * 10)) / 10;
            double ya1 = ((double) Math.round(this.a.getY() * 10)) / 10;
            double ya2 = ((double) Math.round(quadrilateral.a.getY() * 10)) / 10;
            double xb1 = ((double) Math.round(this.b.getX() * 10)) / 10;
            double xb2 = ((double) Math.round(quadrilateral.b.getX() * 10)) / 10;
            double yb1 = ((double) Math.round(this.b.getY() * 10)) / 10;
            double yb2 = ((double) Math.round(quadrilateral.b.getY() * 10)) / 10;
            double xc1 = ((double) Math.round(this.c.getX() * 10)) / 10;
            double xc2 = ((double) Math.round(quadrilateral.c.getX() * 10)) / 10;
            double yc1 = ((double) Math.round(this.c.getY() * 10)) / 10;
            double yc2 = ((double) Math.round(quadrilateral.c.getY() * 10)) / 10;
            double xd1 = ((double) Math.round(this.d.getX() * 10)) / 10;
            double xd2 = ((double) Math.round(quadrilateral.d.getX() * 10)) / 10;
            double yd1 = ((double) Math.round(this.d.getY() * 10)) / 10;
            double yd2 = ((double) Math.round(quadrilateral.d.getY() * 10)) / 10;
            return xa1 == xa2 && ya1 == ya2 && xb1 == xb2 && yb1 == yb2 && xc1 == xc2 && yc1 == yc2 && xd1 == xd2 && yd1 == yd2 ||
                    xa1 == xb2 && ya1 == yb2 && xb1 == xc2 && yb1 == yc2 && xc1 == xd2 && yc1 == yd2 && xd1 == xa2 && yd1 == ya2 ||
                    xa1 == xc2 && ya1 == yc2 && xb1 == xd2 && yb1 == yd2 && xc1 == xa2 && yc1 == ya2 && xd1 == xb2 && yd1 == yb2 ||
                    xa1 == xd2 && ya1 == yd2 && xb1 == xa2 && yb1 == ya2 && xc1 == xb2 && yc1 == yb2 && xd1 == xc2 && yd1 == yc2 ||
                    xa1 == xa2 && ya1 == ya2 && xb1 == xd2 && yb1 == yd2 && xc1 == xc2 && yc1 == yc2 && xd1 == xb2 && yd1 == yb2 ||
                    xa1 == xd2 && ya1 == yd2 && xb1 == xc2 && yb1 == yc2 && xc1 == xb2 && yc1 == yb2 && xd1 == xa2 && yd1 == ya2 ||
                    xa1 == xc2 && ya1 == yc2 && xb1 == xb2 && yb1 == yb2 && xc1 == xa2 && yc1 == ya2 && xd1 == xd2 && yd1 == yd2 ||
                    xa1 == xb2 && ya1 == yb2 && xb1 == xa2 && yb1 == ya2 && xc1 == xd2 && yc1 == yd2 && xd1 == xc2 && yd1 == yc2;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
