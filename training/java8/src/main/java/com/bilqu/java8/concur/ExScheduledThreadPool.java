package com.bilqu.java8.concur;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExScheduledThreadPool {
	

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExScheduledThreadPool mainClass = new ExScheduledThreadPool();
		ScheduledExecutorService schedThreadPool  = Executors.newScheduledThreadPool(5);
		Future<Integer> future = schedThreadPool.schedule( mainClass.new PrintSquare(2), 10, TimeUnit.MICROSECONDS);
		Thread.sleep(100);
		if(future.isDone()) {
			System.out.println(future.get());
		}
		
		
//		The following code shows how to execute a task after 500 milliseconds delay and then repeat it every 100 milliseconds. 
		
//		After scheduling the task, we wait until it fires three times using the CountDownLatch lock, then cancel it using the Future.cancel() method
		
		CountDownLatch lock = new CountDownLatch(3);
		ScheduledFuture<?> sfuture = schedThreadPool.scheduleAtFixedRate(() -> {
		    System.out.println("Printing on a schedule");
		    lock.countDown();
		}, 500, 100, TimeUnit.MILLISECONDS);
		 
		lock.await(1000, TimeUnit.MILLISECONDS);
		sfuture.cancel(true);

	}
	
	public class PrintSquare implements Callable<Integer>{
		
		private int input;
		
	    public PrintSquare(int input) {
			this.input = input;
		}

		@Override
		public Integer call() throws Exception {
			return input*input;
		}
		
	}

}
