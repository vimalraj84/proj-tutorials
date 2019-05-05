package com.bilqu.java8.concur;

public class ExtThread {

	public static void main(String[] args) {
		System.out.println("Main thread execution Starts");   
		ExtThread basicConcur = new ExtThread();
		
		SampleThread sTh = basicConcur.new SampleThread();
		sTh.start();
		
		new Thread(() -> System.out.println("SampleThread JAVA 8")).start();
		System.out.println("Main thread execution Ends");
	}
	
	
	public class SampleThread extends Thread{
		
		@Override
		public void run() {
			System.out.println("SampleThread");
		}
	}

}
