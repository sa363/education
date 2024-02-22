package ru.itfb;

public class Square extends GeometricShape implements GeometricSquare{

    public String getTitle() {
        return title;
    }

    private String title;
    public Square(double x, double y) {
        super(x, y);
        this.title = "Квадрат";
    }

    @Override
    public double area(double x, double y) {
        return x*y;
    }

    @Override
    public String toString() {
        return "Square {" +
                "x='"+ getX() + '\'' +
                ", y='" + getY() + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
