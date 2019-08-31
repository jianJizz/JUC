package com.usc.juc.bfzm;
/**
 * 调用Thread类的静态方法暗示线程调度器当前线程请求让出cpu-->处于就绪状态 
 * @author apple
 *
 */
public class YeildTest implements Runnable{
	public static void main(String[] args) {
		YeildTest yeildTest = new YeildTest();
		new Thread(yeildTest).start();
		new Thread(yeildTest).start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			if (i % 5 == 0) {
				System.out.println(Thread.currentThread() + "yield cpu...");
				//让出cpu资源
				Thread.yield();
			}
		}
		
		System.out.println(Thread.currentThread() + "is over!");
	}
	
	
}
