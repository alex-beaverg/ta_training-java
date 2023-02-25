package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private final Point a;
    private final double radius;
    public Circle(Point a, double radius) {
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
    public void calculateLengths() {

    }
}
