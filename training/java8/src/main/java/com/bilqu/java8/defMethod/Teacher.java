package com.bilqu.java8.defMethod;

public interface Teacher {
	default void pintName() {
		System.out.format("Name : %s","" );
	}
}
