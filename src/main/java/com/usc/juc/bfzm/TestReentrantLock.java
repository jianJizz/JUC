package com.usc.juc.bfzm;

/**
 * 可重入锁：
 * 当一个线程再次获取它自己的锁时，如果不会被阻塞那么该锁就叫做可重入锁
 *
 * 内置锁时可重入锁
 */
public class TestReentrantLock implements Runnable{
    public synchronized void helloA(){
        System.out.println("A");
    }

    public synchronized void helloB(){
        System.out.println("B");
        helloA();
    }


    public static void main(String[] args) {
        new Thread(new TestReentrantLock()).start();
    }

    @Override
    public void run() {
        helloB();
    }
}
