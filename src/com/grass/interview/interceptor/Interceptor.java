package com.grass.interview.interceptor;

public interface Interceptor {
    /**
     * 拦截器，每个拦截器都将在这个方法中拦截链chain，并且触发对下一个拦截器的调用，
     * 直接没有拦截器处理为止
     * @param chain
     * @return
     */
    String intercept(Chain chain);
}
