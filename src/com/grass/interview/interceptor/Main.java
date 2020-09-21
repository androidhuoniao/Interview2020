package com.grass.interview.interceptor;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new CostInterceptor());
        interceptors.add(new CacheInterceptor());
        interceptors.add(new ConnectInterceptor());
        interceptors.add(new ParserNetworkInterceptor());
        interceptors.add(new ResultCallbackInterceptor());
        String request = "开始";
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(interceptors, 0, request);
        String response = realInterceptorChain.process(request);
        System.out.println(response);
    }
}
