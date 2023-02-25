package com.epam.rd.autotasks.figures;

abstract class Figure{
    public abstract double area();
    public abstract String pointsToString();
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }
    public abstract Point leftmostPoint();
    public abstract void calculateLengths();
    public abstract Point centroid();
    public abstract boolean isTheSame(Figure figure);
}
