package com.usc.singleton;


/**
 * 
 * 4.静态内部类方式：
 * 这种方式同样利用了classloder的机制来保证初始化instance时只有一个线程，但是它不会在类加载的时候就实例化insatance
 * 只有显示通过调用getInstance方法时，才会显示装载SingletonHolder类，从而实例化instance
 * @author apple
 *
 */
public class Singleton4 {
	private Singleton4() {}
	
	public static Singleton4 getInstance() {
		return SingleTonHolder.instance;
	}
	
	private static final class SingleTonHolder{
		private static Singleton4 instance = new Singleton4();
	}
}
