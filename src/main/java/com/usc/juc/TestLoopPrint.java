package com.usc.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * 
 * 编写一个程序，开启 3 个线程，这三个线程的 ID 分别为 A、B、C，
   每个线程将自己的 ID 在屏幕上打印 10 遍，要求输出的结果必须按顺序显示。
   如：ABCABCABC…… 依次递归
 * @author apple
 *
 */
public class TestLoopPrint {
	public static void main(String[] args) {
		AlternationDemo alternationDemo = new AlternationDemo();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					alternationDemo.printA();
				}
				
			}
		}, "A").start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					alternationDemo.printB();
				}
			}
		}, "B").start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					alternationDemo.printC();
				}
			}
		}, "C").start();
	}
}


class AlternationDemo{
	private char c = 'A';
	
	private final Lock lock = new ReentrantLock();
	private final Condition conditionA = lock.newCondition();
	private final Condition conditionB = lock.newCondition();
	private final Condition conditionC = lock.newCondition();
	
	public void printA() {
		lock.lock();
		try {
			while(c != 'A') {
				conditionA.await(); // a等待 
			}
			System.out.print(Thread.currentThread().getName());
			c = 'B';
			conditionB.signal(); // 通知B
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void printB() {
		lock.lock();
		try {
			while(c != 'B') {
				conditionB.await(); // b等待 
			}
			System.out.print(Thread.currentThread().getName());
			c = 'C';
			conditionC.signal(); // 通知C
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void printC() {
		lock.lock();
		try {
			while(c != 'C') {
				conditionC.await(); // c等待 
			}
			System.out.print(Thread.currentThread().getName());
			c = 'A';
			conditionA.signal(); // 通知A
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}