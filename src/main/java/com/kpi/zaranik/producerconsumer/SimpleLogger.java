package com.kpi.zaranik.producerconsumer;

public class SimpleLogger {

    public static void printLine(String message) {
        System.out.println(message);
        System.out.flush();
    }
}
