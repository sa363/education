import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.itfb.Circle;
import ru.itfb.FlatShape;
import ru.itfb.Square;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ShapeCalcOptTest {
    @Test
    @DisplayName("Проверка на невозможность создать квадрат с отрицательным значением сторон")
    public void checkFlatShapeCreate() {

        // Проверка на невозможность создать квадрат с отрицательным значением сторон
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
          new Square(BigDecimal.valueOf(-10));
        });

        String expectedMessage = "Значение свойства должно быть неотрицательным";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
//        final FlatShape square = new Square(BigDecimal.valueOf(-10));
//        assertThrows(IllegalArgumentException.class, ()-> {
//            square2.setPerimeter(BigDecimal.valueOf(-10), true);
//        });
//        System.out.println(square2.getPerimeter());
//        System.out.println(square2.getArea());
//
//        square2.setScale(4);
//        System.out.println(square2.getPerimeter());
//        System.out.println(square2.getArea());

    }

    @Test
    @DisplayName("Проверка на невозможность задать периметр с отрицательным значением")
    public void checkFlatShapeSetPerimeter() {

        final FlatShape square = new Square(BigDecimal.valueOf(10));
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
            square.setPerimeter(BigDecimal.valueOf(-10));
        });
        String expectedMessage = "Значение свойства должно быть неотрицательным";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    @DisplayName("Проверка на гибкую проверку задать периметр с отрицательным значением")
    public void checkFlatShapeSetPerimeterWithStrictFalse() {
        final FlatShape square = new Square(BigDecimal.TEN);
        square.setPerimeter(BigDecimal.valueOf(-10), false);
        assertTrue((square.getPerimeter().compareTo(BigDecimal.TEN)==0));
    }
}