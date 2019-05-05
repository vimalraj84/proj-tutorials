package com.bilqu.java8.math;

import java.util.stream.IntStream;

public class Sum {

	public static void main(String[] args) {
		
		System.out.println(IntStream.rangeClosed(1, 20).reduce(1,(op,ip) -> op+ip));
		
		System.out.println(IntStream.rangeClosed(1, 20).reduce(0,(op,ip) -> op+ip));
		
		System.out.println(IntStream.rangeClosed(1, 20).sum());
	}

}
