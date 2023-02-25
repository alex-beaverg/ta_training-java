package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure{
    private final Point a, b, c, d;
    private double x1, y1, x2, y2, x3, y3, x4, y4;
    private double ab, bc, cd, da, ca;
    public Quadrilateral(Point a, Point b, Point c, Point d) {
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
    }
}
