package ru.itfb.sanisimov;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;


import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;


import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Проверка загрузка класса по http")
class CalcTest {


    @Test
    @DisplayName("Загружаем имплементацию класса и выполняем")
    void sum() throws Exception {
//        System.setProperty("javax.net.debug", "all");
        Logger log = LoggerFactory.getLogger(CalcTest.class);
        URL url = new URI("https://dev.uniz.ru/class/").toURL();
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});

        Calc calc = (Calc) Class.forName("ru.itfb.sanisimov.CalcImp", true, urlClassLoader).getDeclaredConstructor().newInstance();
        log.info(()->"Sum %d".formatted(calc.sum(1,1)));
        assertEquals(calc.sum(1, 1), 2);
    }
}