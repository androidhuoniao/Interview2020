package com.grass.interview.sync;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by grassswwang
 * on 2020/9/12
 * Email: grassswwang@tencent.com
 */
public class SafeCounter2 implements Runnable{

    public static volatile int a;
    static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SafeCounter2.calc();
        }
    }
    //计数 注意加锁sychronized
    private  static void calc(){
        lock.lock();
        try{
            if (a<1000){
                a=++a;
                //现场名称与自增后的值
                System.out.println(Thread.currentThread().getName()+":"+a);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }
    //开启五个线程进行计数
    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            SafeCounter2 mySafeThread = new SafeCounter2();
            Thread t = new Thread(mySafeThread);
            t.start();
        }
    }
}

