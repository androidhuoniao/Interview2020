package com.grass.interview.interceptor2;

public class GetResultInterceptor implements Intercepotr {

    @Override
    public Response intercept(Chain chain) {
        Request request = chain.request;
        request.requestDataList.add("GetResultInterceptor");
        Response response = chain.process();
        if (response == null) {
            response = new Response();
        }
        response.responseDataList.add("GetResultInterceptor");
        return response;
    }
}
