package com.grass.interview.sync;

/**
 * Created by grassswwang
 * on 2020/9/12
 * Email: grassswwang@tencent.com
 * 实现一个线程安全的计数器
 */
public class SafeCounter implements Runnable {

    public static volatile int a;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SafeCounter.calc();
        }
    }

    //计数 注意加锁sychronized
    private synchronized static void calc() {

        if (a < 1000) {
            a = ++a;
            //现场名称与自增后的值
            System.out.println(Thread.currentThread().getName() + ":" + a);
        }
    }

    //开启五个线程进行计数
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            SafeCounter mySafeThread = new SafeCounter();
            Thread t = new Thread(mySafeThread);
            t.start();
        }
    }
}
