import ru.itfb.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import static ru.itfb.math.Constant.SCALE;

public class ShapeCalcOpt {


    public static void main(String[] args) {
        final Circle circle = new Circle(BigDecimal.valueOf(5));

        final FlatShape square = new Square(BigDecimal.TEN);
        final FlatShape square2 = new Square(BigDecimal.valueOf(10));
        square2.setPerimeter(BigDecimal.valueOf(-10), false);
//        square2.setScale(4);
        System.out.println(square2.getPerimeter());
        final Sphere sphere = new Sphere(BigDecimal.TWO, BigDecimal.valueOf(33));
        // Есть взаимная зависимость между высотой и боковой стороной (высота <= боковой стороны),
        // поэтому вместо задания трёх длин лучше использовать длины двух сторон и угол,
        // здесь сделано для простоты
        final FlatShape parallelogram = new Parallelogram(BigDecimal.TEN, BigDecimal.ONE, BigDecimal.TWO);
        final VolumetricShape cube = new Cube(BigDecimal.TEN, BigDecimal.valueOf(15.123));
        final VolumetricShape cube2 = new Cube(BigDecimal.ZERO, BigDecimal.ONE);

        System.out.println("Summary area of all shapes: " + sumArea(circle, square, sphere, parallelogram, cube));
        System.out.println("Summary perimeter of flat shapes: " +
                sumPerimeter(circle, square, parallelogram));
        System.out.println("Summary volume of volumetric shapes: " +
                sumVolume(sphere, cube));
        System.out.println("Average radius of round shapes: " +
                calculateAverageRadius(circle, sphere));
        System.out.println("Summary weight of volumetric shapes: " +
                sumWeight(sphere, cube));

        System.out.println("площадь круга: " +
                circle.getArea());
        // Установка масштаба для фигур
        circle.setScale(SCALE);
        square.setScale(SCALE);
        sphere.setScale(SCALE);
        parallelogram.setScale(SCALE);
        cube.setScale(SCALE);

        // Вывод площади и объема фигур после изменения масштаба
        System.out.println("Area of circle after scaling: " + circle.getArea());
        System.out.println("Area of square after scaling: " + square.getArea());
        System.out.println("Volume of sphere after scaling: " + sphere.getArea());
    }

    private static BigDecimal sumArea(Shape... shapes) {
        return Arrays.stream(shapes)
                .map(Shape::getArea)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }

    private static BigDecimal sumPerimeter(FlatShape... shapes) {
        return Arrays.stream(shapes)
                .map(FlatShape::getPerimeter)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }

    private static BigDecimal sumVolume(VolumetricShape... shapes) {
        return Arrays.stream(shapes)
                .map(VolumetricShape::getVolume)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }

    private static BigDecimal calculateAverageRadius(IRound... shapes) {
        return Arrays.stream(shapes)
                .map(IRound::getRadius)
                .reduce(BigDecimal::add)
                .map(sum -> sum.divide(BigDecimal.valueOf(shapes.length), RoundingMode.HALF_UP))
                .orElseThrow();
    }

    private static BigDecimal sumWeight(VolumetricShape... shapes) {
        return Arrays.stream(shapes)
                .map(VolumetricShape::getWeight)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }
}
