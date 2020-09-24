package com.grass.interview.sync;

/**
 * Created by grassswwang
 * on 2020/9/12
 * Email: grassswwang@tencent.com
 * 起步三个线程循环打印ABC10次
 * 使用join就简单了很多啊
 */
public class LoopPrintABC2 {
    public static void main(String[] args) {
        test2();
    }

    /**
     * 这种方案也可以，但是总觉着怪怪的
     */
    public static void test1() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread a = new Thread(new MyPrinter("A"));
                Thread b = new Thread(new MyPrinter("B"));
                Thread c = new Thread(new MyPrinter("C"));
                a.start();
                a.join();
                b.start();
                b.join();
                c.start();
                c.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 这种方式没有问题
     */
    public static void test2() {
        new ThreadA().start();
    }

    static class MyPrinter implements Runnable {
        private String myName;

        public MyPrinter(String myName) {
            this.myName = myName;
        }

        public void run() {
            System.out.println(myName);
        }
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 10; i++) {
                System.out.println("A");
                try {
                    ThreadB threadB = new ThreadB();
                    threadB.start();
                    threadB.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("B");
            try {
                Thread threadC = new ThreadC();
                threadC.start();
                threadC.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("C");
        }
    }

}
