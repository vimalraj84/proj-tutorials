package com.bilqu.java8.math;

import java.util.stream.IntStream;

public class Prime {

	public static void main(String... a) {

		printPrime(999);
		printSqrt(10);
		System.out.println(isPrime(12));
	}

	public static void printPrime(int ip) {
		IntStream.range(1, ip).forEach(i -> {
			if(IntStream.range(2, i).noneMatch( p -> i%p == 0)) {
				System.out.println(String.format("%s is a prime",i ));
			}
		});
	}


	public static void printSqrt(int ip){
		IntStream.range(1, ip).forEach(i -> System.out.println(String.format("Sqrt of %s is %s", i, Math.sqrt(i))));
	}
	
	
	public static boolean isPrime(int ip) {
	    return IntStream.rangeClosed(2, ip/2).noneMatch(i -> ip%i == 0); 
	}
}


