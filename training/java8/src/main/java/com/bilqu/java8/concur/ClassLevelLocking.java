package com.bilqu.java8.concur;

public class ClassLevelLocking {

	private int counter;

	//synchronized method
	public synchronized int getCounter() {
		return counter++;
	}

	//class level synchronization
	public int retrieveCounter() {
		synchronized (ClassLevelLocking.class) {
			return counter++;	
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
