package com.grass.interview.utils;

import com.grass.interview.suanfa.tree.BinaryNode;

import java.util.List;


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

    public static String getLogStr(List<BinaryNode> list) {
        StringBuffer sb = new StringBuffer();
        for (BinaryNode t : list) {
            sb.append(t.value).append(" , ");
        }
        return sb.toString();
    }
}
