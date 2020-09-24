package com.grass.interview.singleton;

public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
        System.out.println("Singleton() is working");
    }

    public static Singleton getInstance() {
        System.out.println("getInstance() is working");
        return instance;
    }
}
