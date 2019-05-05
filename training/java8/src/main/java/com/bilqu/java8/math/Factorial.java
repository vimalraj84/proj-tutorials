package com.bilqu.java8.math;

import java.util.stream.IntStream;

public class Factorial {
	
	public static void main (String[] a) {
		System.out.println(fact(5));
		System.out.println(fact7(5));
	}
	
	public static int fact(int ip) {
		//Reducing is the repeated process of combining all elements.
		//the first argument to the operator is the return value of the previous application 
		//and second argument is the current stream element.
		
		//Where, identity is initial value of type T 
		// Accumulator is a function for combining two values.
		
		return IntStream.rangeClosed(1, ip)
				.reduce(/*identiry*/1, /*accumulator*/(out, in) -> out * in);				
	}
	
	
	public static int fact7(int n) {
	    if (n <= 2) {
	        return n;
	    }
	    return n * fact7(n - 1);
	}

}
