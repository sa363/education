package ru.itfb;

public class SideLengthImpl implements SideLength {
    @Override
    public double length(double x, double y) {
        return (x*2)+(y*2);
    }
}
