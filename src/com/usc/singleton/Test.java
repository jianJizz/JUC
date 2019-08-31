package com.usc.singleton;

public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(()->{
				Singleton6 instance = Singleton6.getInstance();
				System.out.println(instance);
			}).start();
		}
	}
}
