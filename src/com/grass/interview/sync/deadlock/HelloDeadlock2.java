package com.grass.interview.sync.deadlock;

/**
 * Created by grassswwang
 * on 2020/9/12
 * Email: grassswwang@tencent.com
 * 这个是我自己写的例子，更加简单一点
 */
public class HelloDeadlock2 {
    public static void main(String[] args) {
        Object lockObj = new Object();
        Object lockObj2 = new Object();

        Worker worker = new Worker(lockObj, lockObj2, "worker1");
        new Thread(worker).start();

        Worker worker2 = new Worker(lockObj2, lockObj, "worker2");
        new Thread(worker2).start();
    }
}

class Worker implements Runnable {
    private Object lockObj;
    private Object lockObj2;
    private String name;

    public Worker(Object lockObj, Object lockObj2, String name) {
        this.lockObj = lockObj;
        this.lockObj2 = lockObj2;
        this.name = name;
    }

    public void test() {
        synchronized (lockObj) {
            work();
            System.out.println(name + " get lock " + lockObj);
            synchronized (lockObj2) {
                System.out.println(name + " get lock2 " + lockObj2);
                work();
            }
        }
    }

    public void work() {
//        System.out.println(name + " work() is working");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        test();
        System.out.println(name + " run() finished");
    }
}


