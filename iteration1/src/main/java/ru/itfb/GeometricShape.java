package ru.itfb;

public abstract class GeometricShape {

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public GeometricShape() {
    }

    public GeometricShape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double square () {
        return x*y;
    }

    @Override
    public String toString() {
        return "GeometricShape {" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
