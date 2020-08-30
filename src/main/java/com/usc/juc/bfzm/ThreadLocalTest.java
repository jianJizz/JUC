package com.usc.juc.bfzm;

public class ThreadLocalTest {
	
	//private static final ThreadLocal<Integer> THREAD_LOCAL = new ThreadLocal<Integer>();
	
	private static final ThreadLocal<Integer> IHER_THREAD_LOCAL = new InheritableThreadLocal<Integer>();
	public static void main(String[] args) {
		IHER_THREAD_LOCAL.set(100);
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName()+ ": " +IHER_THREAD_LOCAL.get());//获取本地变量的值
			IHER_THREAD_LOCAL.remove(); //清除本地变量
		}).start(); 
		
		//System.out.println(Thread.currentThread().getName()+ ": " +THREAD_LOCAL.get());
		System.out.println(Thread.currentThread().getName()+ ": " +IHER_THREAD_LOCAL.get());
	}
}
