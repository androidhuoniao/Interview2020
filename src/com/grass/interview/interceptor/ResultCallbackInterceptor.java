package com.grass.interview.interceptor;

public class ResultCallbackInterceptor implements Interceptor {
    @Override
    public String intercept(Chain chain) {
        String request = chain.request();
        request = request + "\n数据结果是11111111";
        return request;
    }
}
