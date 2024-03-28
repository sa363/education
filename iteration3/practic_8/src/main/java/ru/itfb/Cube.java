package ru.itfb;

import java.math.BigDecimal;
/**
 * Класс, представляющий куб.
 */
public class Cube extends VolumetricShape {
    private final BigDecimal side;

    public Cube(BigDecimal side, BigDecimal weight) {
        super(side.pow(2).multiply(BigDecimal.valueOf(6)),
                side.pow(3),
                weight);
        this.side = side;
    }
}