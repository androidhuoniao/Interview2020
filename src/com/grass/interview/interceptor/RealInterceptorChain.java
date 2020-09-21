package com.grass.interview.interceptor;

import java.util.List;

public class RealInterceptorChain implements Chain{
    private List<Interceptor> mInterceptors;
    private int index;
    private String request;

    public RealInterceptorChain(List<Interceptor> interceptors, int index, String request) {
        this.mInterceptors = interceptors;
        this.index = index;
        this.request = request;
    }

    @Override
    public String request() {
        return request;
    }

    @Override
    public String process(String request) {
        if (index >= mInterceptors.size()) {
            return "";
        }
        RealInterceptorChain nextChain = new RealInterceptorChain(mInterceptors, index + 1, request);
        Interceptor interceptor = mInterceptors.get(index);
        String response = interceptor.intercept(nextChain);
        return response;
    }
}
