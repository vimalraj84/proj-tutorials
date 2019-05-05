package com.bilqu.java8.concur;

public class LoadTest {

	public static void main(String[] s) {
		// You can change it as per your CPU Core.
		int numCore = 4;
		int numThreadsPerCore = 100;
		double load = 0.8;
		final long duration = 100;
		for (int thread = 0; thread < numCore * numThreadsPerCore; thread++) {
			new Thread(() -> { 				
				long startTime = System.currentTimeMillis();
				try {
					// Loop for the given duration
					while (System.currentTimeMillis() - startTime < duration) {
						Thread.sleep((long) Math.floor((1 - load) * 100));
						System.out.println("Thread ID : " + Thread.currentThread());
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}
