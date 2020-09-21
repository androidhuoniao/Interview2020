package com.grass.interview.interceptor2;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        List<Intercepotr> intercepotrList = new ArrayList<Intercepotr>();
        intercepotrList.add(new CostInterceptor());
        intercepotrList.add(new ConnectInterceptor());
        intercepotrList.add(new GetResultInterceptor());
        Request request = new Request();
        Chain chain = new Chain(request, 0, intercepotrList);
        Response response = chain.process();
        System.out.println("response: " + response.toString());
    }
}
