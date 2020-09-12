package com.grass.interview.sync;

/**
 * Created by grassswwang
 * on 2020/9/12
 * Email: grassswwang@tencent.com
 * 两个线程循环打印A，B
 * 一个线程打印A，一个线程打印B
 */
public class GrassPrintAB2 {
    public static void main(String[] args) {
        GrassPrintAB2 printAB = new GrassPrintAB2();
        printAB.execute();
    }

    private volatile int mCount = 0;
    private static final int MAX_COUNT = 10;
    private Object mLock = new Object();

    public void execute() {
        new Thread(new RunnableA()).start();
        new Thread(new RunnableB()).start();
    }

    class RunnableA implements Runnable {
        @Override
        public void run() {
            synchronized (mLock) {
                while (mCount < MAX_COUNT) {
                    System.out.println("---A");
                    mCount++;
                    try {
                        mLock.wait();
                        mLock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class RunnableB implements Runnable {
        @Override
        public void run() {
            synchronized (mLock) {
                while (mCount < MAX_COUNT) {
                    System.out.println("---B");
                    mCount++;
                    mLock.notify();
                    try {
                        mLock.wait(1000);//改为mLock.wait();也没有错
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
