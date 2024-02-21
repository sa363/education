package ru.itfb;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final Rectangle rectangle = new Rectangle(3, 6);
    private static final Circle circle = new Circle(3);
    public static void main(String[] args) {

        System.out.printf("square rectangle: %.2f \n" , rectangle.square());
        System.out.printf("square circle: %.2f \n" , circle.square());
    }
}