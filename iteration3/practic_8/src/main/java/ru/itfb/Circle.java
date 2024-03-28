package ru.itfb;

import java.math.BigDecimal;

import static ru.itfb.math.Constant.PI;
/**
 * Класс, представляющий круг.
 */
public class Circle extends FlatShape implements IRound {

    private final BigDecimal radius;

    public Circle(BigDecimal radius) {
        super(radius.pow(2).multiply(PI),
                radius.multiply(PI).multiply(BigDecimal.TWO));
        if (radius.compareTo(BigDecimal.ZERO) < 0 ) {
            throw new IllegalArgumentException("Circle radius жопа");
        }
        this.radius = radius;
    }
    /**
     * Возвращает радиус круга.
     *
     * @return радиус круга
     */
    @Override
    public BigDecimal getRadius() {
        return radius;
    }
}
