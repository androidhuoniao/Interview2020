package com.grass.interview.interceptor;

public class ParserNetworkInterceptor implements Interceptor {
    @Override
    public String intercept(Chain chain) {
        String request = chain.request();
        request = request + "\n解析网络数据";
        String result = chain.process(request);
        return result;
    }
}
