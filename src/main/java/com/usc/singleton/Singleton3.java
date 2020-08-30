package com.usc.singleton;
// 3.饿汉式 基于classloader是单线程的避免了多线程同步问题，但是instance在类装载的时候就被实例化了
public class Singleton3 {
	private static Singleton3 instance = new Singleton3();
	
	private Singleton3() {}
	
	public static Singleton3 getInstance() {
		return instance;
	}
	
}
