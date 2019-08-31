package com.usc.juc.bfzm;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/**
 * 使用FutureTask创建线程
 * @author apple
 *
 */
public class CallerTask implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		
		return 20;
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		FutureTask<Integer> futureTask = new FutureTask<Integer>(new CallerTask());
		new Thread(futureTask).start();
		Integer res = futureTask.get();//等待任务执行完并返回结果
		System.out.println(res);
	}
	
}
