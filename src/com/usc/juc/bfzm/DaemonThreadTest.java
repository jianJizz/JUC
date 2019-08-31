package com.usc.juc.bfzm;

public class DaemonThreadTest {
	public static void main(String[] args) {
		Thread thread = new Thread(()->{
			for(;;) {
				
			}
		});
		
		thread.setDaemon(true);
		thread.start();
		System.out.println(Thread.currentThread().getName() + "is over");
		
	}
}
