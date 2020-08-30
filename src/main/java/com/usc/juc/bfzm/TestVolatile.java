package com.usc.juc.bfzm;

/**
 * 1,2,3,4没有依赖关系，如果3和4被指令重排序了，那么结果可能是0。
 * @author apple
 *
 */
public class TestVolatile {
	private static int num = 0;
	private static boolean ready = false;
	
	
	public static void main(String[] args) throws InterruptedException {
		Thread rt = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(!Thread.currentThread().isInterrupted()) {
					if (ready) {//1
						System.out.println(num+num);//2
					}
					
					System.out.println("read thread...");
				}
			}
		});
		
		Thread wt = new Thread(new Runnable() {
			
			@Override
			public void run() {
				num = 2; //3
				ready = true;//4
				System.out.println("write set over");
			}
		});
		
		rt.start();
		
		wt.start();
		
		Thread.sleep(10);
		
		rt.interrupt(); //其他线程调用rt线程的interrupt方法，那么rt线程会被打断并返回抛出InterruptedException
		
		System.out.println("mian end");
		
	}
}
