package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private final Point a;
    private final double radius;
    public Circle(Point a, double radius) {
        if (radius <= 0 || a == null) throw new IllegalArgumentException();
        this.a = a;
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
    @Override
    public String pointsToString() {
        return "(" + a.getX() + "," + a.getY() + ")";
    }
    @Override
    public String toString() {
        return "Circle[(" + a.getX() + "," + a.getY() + ")" + radius + "]";
    }
    @Override
    public Point leftmostPoint() {
        return new Point(a.getX() - radius, a.getY());
    }
    @Override
    public void calculateLengths() {}
    @Override
    public Point centroid() {
        return a;
    }
    @Override
    public boolean isTheSame(Figure figure) {
        try {
            Circle circle = (Circle) figure;
            double x1 = ((double) Math.round(this.a.getX() * 10)) / 10;
            double x2 = ((double) Math.round(circle.a.getX() * 10)) / 10;
            double y1 = ((double) Math.round(this.a.getY() * 10)) / 10;
            double y2 = ((double) Math.round(circle.a.getY() * 10)) / 10;
            double r1 = ((double) Math.round(this.radius * 10)) / 10;
            double r2 = ((double) Math.round(circle.radius * 10)) / 10;
            return x1 == x2 && y1 == y2 && r1 == r2;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
