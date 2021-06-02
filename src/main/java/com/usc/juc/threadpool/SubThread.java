package com.usc.juc.threadpool;

/**
 * @author jianjianDuan
 * @date 2021/6/2 6:40 下午
 */
public class SubThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "hello");
    }
}
