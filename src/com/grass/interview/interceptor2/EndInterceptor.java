package com.grass.interview.interceptor2;

public class EndInterceptor implements Intercepotr {

    @Override
    public Response intercept(Chain chain) {
        Request request = chain.request;
        request.requestDataList.add("EndInterceptor");
        Response response = chain.process();
        response.responseDataList.add("EndInterceptor");
        return response;
    }
}
