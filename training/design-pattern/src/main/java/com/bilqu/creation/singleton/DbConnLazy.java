package com.bilqu.creation.singleton;

public class DbConnLazy {
	
	//*************************************************************************************************************//
	private static DbConnLazy dbConnLazy = null;
	
	
	private DbConnLazy() {
		
	}
	
	//This is not thread safe
	public static DbConnLazy getInstance() {
		if(dbConnLazy != null)
			dbConnLazy = new DbConnLazy();
		return dbConnLazy;
	}
	
	
	//*************************************************************************************************************//
	// Only one thread can execute this at a time.  But it has some performance impact. 
    public static synchronized DbConnLazy getSyncInstance() 
    { 
        if (dbConnLazy==null)
        	dbConnLazy = new DbConnLazy();
        return dbConnLazy;
    } 
    
    //*************************************************************************************************************//
    

}
