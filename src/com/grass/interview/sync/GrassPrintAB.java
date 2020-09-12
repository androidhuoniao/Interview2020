package com.grass.interview.sync;

/**
 * Created by grassswwang
 * on 2020/9/12
 * Email: grassswwang@tencent.com
 */
public class GrassPrintAB {
    public static void main(String[] args) {
        GrassPrintAB printAB = new GrassPrintAB();
        printAB.execute();
    }

    public void execute() {
        new Thread(new PrintRunnable()).start();
    }

    private volatile int mCount;
    private char[] chars = {'A', 'B'};

    class PrintRunnable implements Runnable {
        @Override
        public void run() {
            while (mCount < 10) {
                synchronized (GrassPrintAB.class) {
                    System.out.println("-----" + chars[mCount % chars.length]);
                    mCount++;
                }
            }
        }
    }
}
