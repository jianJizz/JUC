package com.usc.juc.bfzm;


public class NotifyAndNotifyAll {
	//共享变量
	private static volatile Object resA =  new Object();
	public static void main(String[] args) throws InterruptedException {
		Thread threadA = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (resA) {
					System.out.println("线程A get resA lock");
					try {
						System.out.println("ThreadA begin wait");
						resA.wait();
						System.out.println("ThreadA end");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread threadB = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (resA) {
					System.out.println("ThreadB get resA lock");
					try {
						System.out.println("ThreadB begin wait");
						resA.wait();
						System.out.println("ThreadB end");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		

		Thread threadC = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (resA) {
					System.out.println("ThreadC bgin notify");
//					resA.notify();
					//一个需要注意的地方是，在共享变量上调用 notifyAll()方法只会唤醒调用这个方法前 
					//调用了 wait系列函数而被放入共享变量等待集合里面的线程。
					resA.notifyAll();
				}
			}
		});
		threadA.start();
		threadB.start();
		//休眠的意义在于让线程AB先去执行其里面的wait方法，如果注释掉则会出现AB某个线程无法获取锁的情况
		Thread.sleep(1000);
		threadC.start();
		
		//等待线程结束
		//在项目实践中经常会遇到一个场景，就是需要等待某几件事情完成后才能继续往下执 行 ， 
		//比如 多个线程加载资源 ， 需要等待多个线程全部加载完毕再汇总处理。 Thread类的join方法就可以做这个
//		threadA.join();
//		threadB.join();
//		threadC.join();
		
	}
	
	
	
}
