package ru.itfb;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static ru.itfb.math.Constant.PI;

public class Sphere extends VolumetricShape implements IRound {
    // Прим.: У сферы, как и у круга, есть радиус, но нет периметра
    // Поэтому не вполне корректно делать и наследование сферы от круга, и делать круг как сферу с нулевым объёмом
    private final BigDecimal radius;

    public Sphere(BigDecimal radius, BigDecimal weight) {
        super(radius.pow(3).multiply(PI),
                radius.pow(3).multiply(PI).multiply(BigDecimal.valueOf(4)).divide(BigDecimal.valueOf(3), RoundingMode.HALF_UP),
                weight);
        this.radius = radius;
    }

    @Override
    public BigDecimal getRadius() {
        return radius;
    }
}