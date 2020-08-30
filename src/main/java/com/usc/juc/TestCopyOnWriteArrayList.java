package com.usc.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCopyOnWriteArrayList {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CallableRunnable callableRunnable = new CallableRunnable();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(callableRunnable);
		new Thread(futureTask).start();
		
		try {
			Integer sum = futureTask.get();
			System.out.println(sum);
		} catch (Exception e) {
		}
		
		
		
	}
}


class CallableRunnable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += i ;
		}
		
		System.out.println(sum);
		return sum;
	}

	
	
}

