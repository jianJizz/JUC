package com.usc.singleton;
// 2.懒汉式 线程安全 但是效率很低，99%的情况下不需要同步
public class Singleton2 {
	private static Singleton2 instance = null;
	
	private Singleton2() {}
	
	public synchronized static Singleton2 getInstance() {
		if (instance == null) {
			instance = new Singleton2();
		}
		
		return instance;
	}
	
}
