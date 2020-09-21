package com.grass.interview.interceptor2;

import java.util.List;

/**
 * 难点1：response怎么处理，怎么包装的
 * 难点2：response是怎么回溯的
 */
public class Chain {
    public Request request;
    public List<Intercepotr> intercepotrList;
    public int index;

    public Chain(Request request, int index, List<Intercepotr> intercepotrList) {
        this.request = request;
        this.index = index;
        this.intercepotrList = intercepotrList;
    }

    public Response process() {
        if (index >= intercepotrList.size()) {
            return null;
        }
        Intercepotr intercepotr = intercepotrList.get(index);
        Chain nextchain = new Chain(request, index + 1, intercepotrList);
        Response response = intercepotr.intercept(nextchain);
        return response;
    }
}
