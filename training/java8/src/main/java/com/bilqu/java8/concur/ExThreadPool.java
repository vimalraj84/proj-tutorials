package com.bilqu.java8.concur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExThreadPool {


	private static final int CORE_POOL_SIZE = 5;
	private static final int MAX_POOL_SIZE = 10;
	private static final int KEEP_ALIVE_TIME = 10;
	private static final TimeUnit TIME_UNIT = TimeUnit.MILLISECONDS;
	private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<Runnable>();
	
	private ThreadPoolExecutor taskExecutor = null;

	//	corePoolSize: corePoolSize is the number of threads to keep in the pool, even if they are idle
	//	MaximumPoolSize: the maximum number of threads to allow in the pool
	//	keepAliveTime: When you have more threads already available than corePoolSize, then keepAliveTime is time up to which that thread will wait for task before terminating.
	//	unit: time unit is for keepAliveTime
	//	workQueue: workQueue is the BlockingQueue which holds the tasks before execution.
	//	threadFactory: Factory which is used to create a new Thread.
	//	handler : RejectedExecutionHandler which is used in case execution is block or queue is full. Lets create a RejectedExecutionHandler for handling rejected task.


	public static void main(String[] args){

		ExThreadPool threadPool = new ExThreadPool();
		
		
		try {
			threadPool.taskExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORK_QUEUE);

			Tester Tester = threadPool.new Tester(1,5);
			Tester Tester1 = threadPool.new Tester(5,10);
			Tester Tester2 = threadPool.new Tester(10,15);
			Tester Tester3 = threadPool.new Tester(15,20);

			List<Future<List<Integer>>> futureList = new ArrayList<Future<List<Integer>>>();
		
			futureList.add(threadPool.taskExecutor.submit(Tester));
			futureList.add(threadPool.taskExecutor.submit(Tester1));
			futureList.add(threadPool.taskExecutor.submit(Tester2));
			futureList.add(threadPool.taskExecutor.submit(Tester3));
			Thread.sleep(100);

			for(Future<List<Integer>> future : futureList ) {
				Stream.of(future).forEach(i -> 
				{
					if (i.isDone()) 
					{
						try {
							System.out.println(i.get());
						} catch (InterruptedException | ExecutionException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("None");
					}
				});
			}
			


		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		threadPool.taskExecutor.shutdown();
	}


	public class Tester implements Callable<List<Integer>>{

		private int start;
		private int end;

		public Tester(int start,int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public List<Integer> call() throws Exception {
			return IntStream.range(start, end).boxed().collect(Collectors.toList());
		}

	}



}
