package com.grass.interview.interceptor2;

public class CostInterceptor implements Intercepotr {

    @Override
    public Response intercept(Chain chain) {
        chain.request.requestDataList.add("CostInterceptor");
        Response response = chain.process();
        response.responseDataList.add("CostInterceptor");
        return response;
    }
}
