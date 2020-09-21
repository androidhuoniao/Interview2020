package com.grass.interview.interceptor2;

import java.util.ArrayList;
import java.util.List;

public class Request {
    public List<String> requestDataList = new ArrayList<>();

    @Override
    public String toString() {
        return "Request{" +
                "requestDataList=" + requestDataList +
                '}';
    }
}
