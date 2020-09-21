package com.grass.interview.interceptor;

public interface Chain {

     String request();

     String process(String request);
}
