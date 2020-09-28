package com.grass.interview.proxy;

public class StaticProxy implements IFactory {
    private IFactory realFactory;

    public StaticProxy(IFactory realFactory) {
        this.realFactory = realFactory;
    }

    @Override
    public String getCar() {
        return "staticFactory: " + realFactory.getCar();
    }
}
