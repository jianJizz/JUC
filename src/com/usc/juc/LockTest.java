package com.usc.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock锁解决售票问题
 * Lock需要通过lock()方法上锁，通过unlock()方法释放锁。为了保证锁能释放，所有unlock方法一般放在finally中去执行。
 * @author apple
 *
 */
public class LockTest {
	public static void main(String[] args) {
		Tickect tickect = new Tickect();
		new Thread(tickect, "窗口1").start();
		new Thread(tickect, "窗口2").start();
		new Thread(tickect, "窗口3").start();
	}
}

class Tickect implements Runnable{
	private final ReentrantLock lock = new ReentrantLock();
	private volatile int ticket = 100;
	@Override
	public void run() {
		while (ticket > 0) {
			lock.lock();
			try {
				if (ticket > 0) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "售票成功，余票为: " + (--ticket));
				}
			}finally {
				lock.unlock();
			}
		}
		
	}
	
}
