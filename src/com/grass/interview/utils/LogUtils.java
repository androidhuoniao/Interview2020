package com.grass.interview.utils;

public class LogUtils {
    public static <T> String getLogStr(T[] array) {
        StringBuffer sb = new StringBuffer();
        for (T t : array) {
            sb.append(t.toString()).append(" , ");
        }
        return sb.toString();
    }

    public static String getLogStr(int[] array) {
        StringBuffer sb = new StringBuffer();
        for (int t : array) {
            sb.append(t).append(" , ");
        }
        return sb.toString();
    }
}
