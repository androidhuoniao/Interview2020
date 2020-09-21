package com.grass.interview.interceptor;

public class CacheInterceptor implements Interceptor {

    @Override
    public String intercept(Chain chain) {
        String request = chain.request();
        request += "\n尝试从cache中获取数据";
        request += "\ncache中没有数据，尝试从网络中获取数据";
        String result = chain.process(request);
        return result;
    }
}
