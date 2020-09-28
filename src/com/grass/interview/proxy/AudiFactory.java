package com.grass.interview.proxy;

public class AudiFactory implements IFactory {
    @Override
    public String getCar() {
        return "audi";
    }
}
