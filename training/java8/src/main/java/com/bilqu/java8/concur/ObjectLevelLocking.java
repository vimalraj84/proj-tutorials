package com.bilqu.java8.concur;

import java.util.stream.IntStream;

public class ObjectLevelLocking {

	private int counter;

	//synchronized method
	public synchronized int getCounter() {
		return counter++;
	}

	//Object level synchronization
	public int retrieveCounter() {
		synchronized (this) {
			return counter++;	
		}
	}


	public static void main(String[] args) {
		ObjectLevelLocking objectLevelLocking = new ObjectLevelLocking();
		IntStream.range(0, 10).forEach(i -> System.out.println(objectLevelLocking.getCounter()));
		IntStream.range(0, 10).forEach(i -> System.out.println(objectLevelLocking.retrieveCounter()));
	}

}
