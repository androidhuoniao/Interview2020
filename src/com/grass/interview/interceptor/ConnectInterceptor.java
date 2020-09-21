package com.grass.interview.interceptor;

public class ConnectInterceptor implements Interceptor {

    @Override
    public String intercept(Chain chain) {
        String request = chain.request();
        request+= "\n连接网络开始";
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return chain.process(request);
    }

}
