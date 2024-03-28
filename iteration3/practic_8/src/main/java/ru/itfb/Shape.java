package ru.itfb;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

/**
 * Класс, представляющий геометрическую фигуру.
 */
public abstract class Shape implements IScalable {
    private final BigDecimal area;
    private Integer scale;


    Shape(BigDecimal area) {
        if (area == null) {
            throw new IllegalArgumentException("Значение area не может быть null");
        }

        if (area.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Значение area должно быть больше или равно нулю");
        }
        this.area = area;
        this.scale = 1; //Масштаб по умолчанию
    }

    /**
     * Возвращает площадь фигуры.
     *
     * @return площадь фигуры
     * @throws IllegalArgumentException если значение свойства area равно null
     */
    @NotNull
    public BigDecimal getArea() {
        return area.multiply(new BigDecimal(scale));
    }


    /**
     * Возвращает маштаб фигуры.
     *
     * @return маштаб фигуры
     */
    @Override
    @NotNull
    public  Integer getScale() {
        return scale;
    }


    @Override
    public void setScale(Integer scale) {
        if (scale > 0) {
            this.scale = scale;
        } else {
            throw new IllegalArgumentException("Масштаб должен быть положительным");
        }
    }
}
