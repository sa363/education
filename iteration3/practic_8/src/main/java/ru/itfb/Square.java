package ru.itfb;


import java.math.BigDecimal;
/**
 * Класс, представляющий геометрическую фигуру квадрат
 */
public class Square extends Parallelogram {
    public Square(BigDecimal side) {
        super(side, side, side);
    }
}