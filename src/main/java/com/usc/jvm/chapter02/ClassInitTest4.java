package com.usc.jvm.chapter02;

/**
 * @author jianjianDuan
 * @date 2021/11/30 11:30 AM
 *
 * 4. 虚拟机必须保证一个类的<clinit>()方法在多线程下被同步加锁
 */
public class ClassInitTest4 {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            DeadThread dead = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "结束");
        };

        Thread t1 = new Thread(r,"线程1");
        Thread t2 = new Thread(r,"线程2");

        t1.start();
        t2.start();
    }
}

class DeadThread{
    static{
        if(true){
            System.out.println(Thread.currentThread().getName() + "初始化当前类");
            while(true){

            }
        }
    }
}