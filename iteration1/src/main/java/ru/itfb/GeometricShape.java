package ru.itfb;

public abstract class GeometricShape {

    private double x;
    private double y;

    public GeometricShape() {
    }

    public GeometricShape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double square () {
        return x*y;
    }
}
