package com.bilqu.java8.concur;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyExecutorService {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Executor executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> System.out.println("Single thread executor"));
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future<String> future = executorService.submit(() -> "Fixed Thread Pool");
		// some operations
		String result = future.get();
		System.out.println(result);


	}

}
