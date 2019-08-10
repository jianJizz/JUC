package com.usc.juc.bczm;
/**
 * 死锁的四个条件:
 * 1.互斥条件: 同一时刻只能由一个线程占用该资源
 * 2.请求并持有: 线程获取到资源时不会被其他线程抢占，直到该线程释放资源
 * 3.不可剥夺条件:线程在获取到的资源在自己使用完成之前不能被其他线程抢占，直到使用完毕由自己释放
 * 4.环路等待: A->B->C->A
 * @author apple
 *
 */
public class DeadLock {
	//创建资源
	private static String resA = "A";
	private static String resB = "B";
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (resA) {
					System.out.println("Thread A get resA");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Thread A wait resB...");
					synchronized (resB) {
						System.out.println("Thread A get resB");
					}
				}
			}
		}, "Thread-A").start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (resB) {
					System.out.println("Thread B get resB");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Thread B wait resA...");
					synchronized (resA) {
						System.out.println("Thread B get resA");
					}
				}
			}
		}, "Thread-B").start();
		
	}
}
