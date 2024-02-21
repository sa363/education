package ru.itfb;

public class Circle extends GeometricShape{
    private double r;

    public Circle(double r) {
        this.r= r;
    }

    @Override
    public double square() {
        return Math.PI*Math.pow(r, 2);
    }
}
