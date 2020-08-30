package com.usc.juc;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * @author apple
 *
 */
public class TestReadWriterLock {
	public static void main(String[] args) {
		//开启一个线程写，5个线程读
		ReadWriteDemo rd = new ReadWriteDemo();
	
		new Thread(()->{
			rd.write(new Random().nextInt(10));
		}, "w").start();
		
		for (int i = 0; i < 20; i++) {
			new Thread(() ->  {
				rd.read();
			}, "r" + i).start();
		}
	}
}

class ReadWriteDemo{
	private int num = 0;
	
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private final Lock readLock = readWriteLock.readLock(); //读锁
	private final Lock writeLock = readWriteLock.writeLock(); //写锁
	
	
	public void write(int num) {
		writeLock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "--" + num);
			this.num = num;
		} finally {
			writeLock.unlock();
		}
	}
	
	public void read() {
		readLock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "--" + num);
		} finally {
			readLock.unlock();
		}
	}
}

