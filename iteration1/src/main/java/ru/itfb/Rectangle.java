package ru.itfb;

public class Rectangle extends GeometricShape implements GeometricSquare{

    public String getTitle() {
        return title;
    }

    private String title;

    public Rectangle(double x, double y) {
        super(x, y);
        this.title = "Прямоугольник";
    }

    @Override
    public double area(double x, double y) {
        return x*y;
    }
}
