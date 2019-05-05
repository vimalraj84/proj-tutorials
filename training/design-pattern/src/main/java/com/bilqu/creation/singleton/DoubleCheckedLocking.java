package com.bilqu.creation.singleton;

//Double Checked Locking
public class DoubleCheckedLocking {
    //volatile which ensures that multiple threads offer the obj variable correctly when it is being initialized to Singleton instance. 
    //This method drastically reduces the overhead of calling the synchronized method every time.
    private static volatile DoubleCheckedLocking syncDbConnLazy = null;
    
    public static DoubleCheckedLocking getInstance() {
    	if(syncDbConnLazy == null) {
    		//This is thread safe
    		synchronized (DoubleCheckedLocking.class) {
    			// check again as multiple threads can reach above step
    			if(syncDbConnLazy == null) {
    				syncDbConnLazy = new DoubleCheckedLocking();
    			}
    		}
    	}
    	return syncDbConnLazy; 
    }
    
    private DoubleCheckedLocking() {
    	
    }
}
