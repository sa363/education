package ru.itfb;

import lombok.Getter;

import java.math.BigDecimal;
/**
 * Класс, представляющий объемную фигуру.
 */
@Getter
public abstract class VolumetricShape extends Shape {
    private BigDecimal volume;


    private BigDecimal weight;

    public VolumetricShape(BigDecimal area, BigDecimal volume, BigDecimal weight) {
        super(area);
        if (volume == null || weight == null) {
            throw new IllegalArgumentException("Параметры volume или weight не могут быть null");
        }
        this.volume = volume;
        this.weight = weight;
    }

    public BigDecimal getVolume() {
        return volume.multiply(new BigDecimal(getScale()));
    }

}
