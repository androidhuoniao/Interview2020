package com.grass.interview.interceptor2;

public class ConnectInterceptor implements Intercepotr {

    @Override
    public Response intercept(Chain chain) {
        Request request = chain.request;
        request.requestDataList.add("ConnectInterceptor");
        Response response = chain.process();
        response.responseDataList.add("ConnectInterceptor");
        return response;
    }
}
