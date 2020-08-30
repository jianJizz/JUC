package com.usc.singleton;
/**
 * 枚举方式
 * 这种方式是Effective Java作者Josh Bloch 提倡的方式，它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 * @author apple
 *
 */
public enum Singleton5 {
	INSTANCE;
	public void whateverMethod() {  
    }
}
