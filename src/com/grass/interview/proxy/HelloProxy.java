package com.grass.interview.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloProxy {
    public static void main(String[] args) {
        AudiFactory audiFactory = new AudiFactory();
        String car = new StaticProxy(audiFactory).getCar();
        System.out.println("StaticProxy: " + car);
        dynamicProxy();
    }

    public static void dynamicProxy() {
        IFactory instance = (IFactory) Proxy.newProxyInstance(HelloProxy.class.getClassLoader(), AudiFactory.class.getInterfaces(), new MyInvocationHandler(new AudiFactory()));
        System.out.println("dynamicProxy: " + instance.getCar());
    }

    static class MyInvocationHandler implements InvocationHandler {

        private IFactory realFactory;

        public MyInvocationHandler(IFactory realFactory) {
            this.realFactory = realFactory;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            System.out.println("MyInvocationHandler.invoke "+proxy);
//            return "MyInvocationHandler: " + realFactory.getCar();
            return "MyInvocationHandler: " + method.invoke(realFactory,args);
        }
    }
}
