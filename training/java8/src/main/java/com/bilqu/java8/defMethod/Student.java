package com.bilqu.java8.defMethod;

public interface Student {
	
	default void pintName() {
		System.out.format("Name : %s","" );
	}

}
