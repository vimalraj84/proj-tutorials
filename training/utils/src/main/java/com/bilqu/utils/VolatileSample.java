package com.bilqu.utils;

public class VolatileSample {

	private static int NON_VOLATILE_ATTR = 1;

	//The volatile force the thread to update the original variable for each variable. 
	private static volatile int VOLATILE_ATTR = 1;


	public static void main(String[] s) {
		demoVolatile();
		demoNonVolatile();

	}
	
	
	//	When the thread is created, it copies the value of all accessible variables in its own memory. 
	//	The volatile keyword is used to say to the jvm "Warning, this variable may be modified in an other Thread". 
	private static void demoVolatile() {
		//VolatileSample Listener
		new Thread(() -> {int local = VOLATILE_ATTR;
		while ( local < 5){
			if( local!= VOLATILE_ATTR){
				System.out.format("VOLATILE_ATTR Changes: %d \n", VOLATILE_ATTR);
				local= VOLATILE_ATTR;
			}
		}}).start();

		//VolatileSample Updater
		new Thread(() -> {

			int local = VOLATILE_ATTR;
			while (VOLATILE_ATTR <5){
				System.out.format("Incrementing VOLATILE_ATTR to %d \n", local+1);
				VOLATILE_ATTR = ++local;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) { e.printStackTrace(); }
			}
		}).start();
	}

	
	private static void demoNonVolatile() {
		//VolatileSample Listener
		new Thread(() -> {int local = NON_VOLATILE_ATTR;
		while ( local < 5){
			if( local!= NON_VOLATILE_ATTR){
				System.err.format("NON_VOLATILE_ATTR Changes: %d \n", VOLATILE_ATTR);
				local= NON_VOLATILE_ATTR;
			}
		}}).start();

		//VolatileSample Updater
		new Thread(() -> {

			int local = NON_VOLATILE_ATTR;
			while (NON_VOLATILE_ATTR <5){
				System.err.format("Incrementing NON_VOLATILE_ATTR to %d \n", local+1);
				NON_VOLATILE_ATTR = ++local;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) { e.printStackTrace(); }
			}
		}).start();
	}


	//	Older Syntax: 
	//		
	//		Thread thread = new Thread() {
	//	    public void run() {
	//	        // your code here
	//	    }
	//	}
	//
	//	thread.start();
}
