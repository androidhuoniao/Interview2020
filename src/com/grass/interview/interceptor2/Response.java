package com.grass.interview.interceptor2;

import java.util.ArrayList;
import java.util.List;

public class Response {
    public List<String> responseDataList = new ArrayList<>();

    @Override
    public String toString() {
        return "Response{" +
                "responseDataList=" + responseDataList +
                '}';
    }
}
