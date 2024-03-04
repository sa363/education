package ru.itfb;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final Rectangle rectangle = new Rectangle(3, 6);
    private static final Square square = new Square(3, 3);

    public static void main(String[] args) {
        System.out.printf("Площадь %s : %.2f \n", rectangle.getTitle(), rectangle.square());
        System.out.printf("Площадь %s : %.2f \n", square.getTitle(), square.square());
        List<GeometricShape> geometrics = List.of(rectangle, square);

        geometrics.stream()
                .map(geometricShape ->
                        geometricShape.getX() * 2 + geometricShape.getY() * 2)
                .forEach(System.out::println);


        // Выведем только квадрат
        geometrics.stream()
                .filter(geometricShape -> geometricShape.getX() == geometricShape.getY())
                .forEach(System.out::println);
    }
}