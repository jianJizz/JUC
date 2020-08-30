package com.usc.singleton;


/**
 * 双重检测
 * 当thread1和thread都过了第一层检测，
 * 如果不加第二层判断，thread2会直接new Singleton6 导致有多个实例
 * @author apple
 *
 */
public class Singleton6 {
	private static Singleton6 instance = null;
	
	private Singleton6() {}
	
	public static Singleton6 getInstance() {
		if (instance == null) {
			//thread1 
			//thread2
			synchronized (Singleton6.class) {
				if (instance == null) {
					//thread1
					instance = new Singleton6();
				}
			}
		}
		return instance;
	}
}
