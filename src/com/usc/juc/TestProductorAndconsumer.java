package com.usc.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 消费者生产者
 * 出现问题:
 * 它也会不断的去消费，也会一直打印“缺货”，即使是产品已满状态，也会不断地进货。
 * 解决:
 * 等待唤醒机制
 * 为了避免虚假唤醒问题，wait方法应该总是在循环中使用
 * 将synchronized改为lock
 * @author apple
 *
 */
public class TestProductorAndconsumer {
	public static void main(String[] args) {
		Clerk clerk =  new Clerk();
		Producer producer = new Producer(clerk);
		Consumer consumer = new Consumer(clerk);
		new Thread(producer, "生产者1").start();
		new Thread(producer, "生产者2").start();
		new Thread(consumer, "消费者1").start();
		new Thread(consumer, "消费者2").start();
		new Thread(consumer, "消费者3").start();
		new Thread(consumer, "消费者4").start();
		//生产者生产的数量一定和消费者消费的数量一致 要不了程序不会结束
//		new Thread(consumer, "消费者5").start();
	}
}

//卖家
class Clerk {
	//产品数量
	private int product = 0;
	private final Lock lock = new ReentrantLock();
	//lock.newCondition创建的每个ConditionObject的内存地址都是不一样的，是不同的对象
	private final Condition notFull =  lock.newCondition(); //生产者线程
	private final Condition notEmpty =  lock.newCondition(); //消费者线程
	private int maxSize = 10;
	//进货
	public void get() {
		lock.lock();
		try {
			while (product == maxSize) {
				System.out.println("仓库已满,不能再进货了");
				try {
					notFull.await(); //满了就等待 生产者
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
			System.out.println(Thread.currentThread().getName() + "仓库已进货， 仓库存货为: " +  ++product);
			notEmpty.signalAll(); //通知消费者可以消费
		} finally {
			lock.unlock();
		} 
		
	}
	
	//发货
	public void sale() {
		lock.lock();
		try {
			while (product == 0) {
				System.out.println("仓库缺货");
				try {
					notEmpty.await(); //消费者等待
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "仓库已出货, 仓库存货为: " + --product);
			notFull.signalAll(); //通知生产者生产
		} finally {
			lock.unlock();
		}
		
	}
	
}

//生产者
class Producer implements Runnable{
	private Clerk clerk;
	public  Producer(Clerk clerk) {
		this.clerk =  clerk;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 10; i++) {
			clerk.get();
		}
	}
	
	
}

//消费者
class Consumer implements Runnable{
	private Clerk clerk;
	public  Consumer(Clerk clerk) {
		this.clerk =  clerk;
	}
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			clerk.sale();
		}
	}
	
}