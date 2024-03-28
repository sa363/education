package ru.itfb;


import java.math.BigDecimal;

/**
 * Класс, представляющий плоскую геометрическую фигуру.
 */
public abstract class FlatShape extends Shape {
    private BigDecimal perimeter;

    public FlatShape(BigDecimal area, BigDecimal perimeter) {
        super(area);
        this.setPerimeter(perimeter);
    }

    /**
     * Устанавливает периметр фигуры.
     *
     *@param perimeter периметр фигуры
     *@throws IllegalArgumentException если переданное значение равно null
     *
     */
    public void setPerimeter(BigDecimal perimeter) {
        setPerimeter(perimeter, true);
    }

    /**
     *Устанавливает периметр формы и выполняет проверку на отрицательные значения в зависимости от параметра strict.
     *
     *@param perimeter перимерт формы
     *@param strict параметр указывающий строгость проверки. Если стоит тру - выбросить ошибку при значении меньше ноля. Если стоит false - принять по модолю
     */
    public void setPerimeter(BigDecimal perimeter, boolean strict) {
        if (perimeter == null) {
            throw new IllegalArgumentException("Значение свойства perimeter не может быть null");
        }
        if (strict && perimeter.compareTo(BigDecimal.ZERO) < 0 ) {
            throw new IllegalArgumentException("Значение свойства должно быть неотрицательным");
        }
        this.perimeter = perimeter;
    }

    /**
     * Возвращает периметр фигуры.
     *
     * @return периметр фигуры
     */
    public BigDecimal getPerimeter() {
        return perimeter.multiply(new BigDecimal(getScale())).abs();
    }
}
