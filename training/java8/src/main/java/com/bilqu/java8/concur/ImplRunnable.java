package com.bilqu.java8.concur;

public class ImplRunnable {

	public static void main(String[] args) {
		System.out.println("Main thread execution Starts");
		ImplRunnable implRunnable = new ImplRunnable();
		
		SampleRunn runn = implRunnable.new SampleRunn();
		
		new Thread(runn).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("After Implementing Runnable as Annonymous Inner Class");
				
			}
		}).start();
		
		Runnable run = () -> { System.out.println("After Implementing Runnable JAVA 8"); };
		new Thread(run).start();
		
		try {
			synchronized(implRunnable) { /// It does not release the lock on lockedObject. 
			Thread.sleep(1000l);// So either after 1000 miliseconds, current thread will wake up, or after we call t.interrupt() method. 
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main thread execution Ends");
					
	}
	
	
	public class SampleRunn implements Runnable{

		@Override
		public void run() {
			System.out.println("After Implementing Runnable");
			
		}
		
	}
	
	

}
