package com.grass.interview.interceptor;

public class CostInterceptor implements Interceptor {
    @Override
    public String intercept(Chain chain) {
        long start = System.currentTimeMillis();
        String request = chain.request();
        request = request + "\n计时开始";
        String result =  chain.process(request);
        long end = System.currentTimeMillis();
        long cost = end - start;
        result = result + "\ncost "+cost;
        return result;
    }
}
