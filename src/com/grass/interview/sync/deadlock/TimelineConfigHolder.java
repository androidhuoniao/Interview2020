package com.grass.interview.sync.deadlock;

import org.omg.CORBA.OBJ_ADAPTER;

import java.sql.Time;

/**
 * Created by grassswwang
 * on 2020/9/12
 * Email: grassswwang@tencent.com
 */
public class TimelineConfigHolder {

    public static final String KEY_TAG = "timeline";
    private String mTag;

    public TimelineConfigHolder(String tag) {
        this.mTag = tag;
    }

    private static Object lock = new Object();
//    public static TimelineConfigHolder obtain() {
//        synchronized (lock) {
//            TimelineConfigHolder configHolder = new TimelineConfigHolder(KEY_TAG);
//            return configHolder;
//        }
//    }

    public static TimelineConfigHolder obtain() {
        TimelineConfigHolder configHolder = new TimelineConfigHolder(KEY_TAG);
        return configHolder;
    }

    public synchronized String getValue() {
        String result = "";

        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index + " obtain() is working");
                    TimelineConfigHolder.obtain();
                }
            }).start();
        }
    }
}