package ru.itfb;


import ru.itfb.sanisimov.Calc;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws Exception {

        URL url = new URL("https://dev.uniz.ru/class/");
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});

        Calc calc = (Calc) Class.forName("ru.itfb.sanisimov.CalcImp", true, urlClassLoader).newInstance();

        Logger.getGlobal().info("Sum %d".formatted(calc.sum(1, 1)));

    }
}