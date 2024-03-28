package ru.itfb;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
/**
 * Класс, представляющий геометрическую фигуру параллелограм
 */
public class Parallelogram extends FlatShape {
    private final BigDecimal base; // Основание: __
    private final BigDecimal height; // Высота: |
    private final BigDecimal side; // Боковая грань: /

    public Parallelogram(BigDecimal base, BigDecimal height, BigDecimal side) {
        super(base.multiply(height),
                base.add(side).multiply(BigDecimal.TWO));
        this.base = base;
        this.height = height;
        this.side = side;
    }
}