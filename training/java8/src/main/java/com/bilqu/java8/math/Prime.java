package com.bilqu.java8.math;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Prime {

	public static void main(String... a) {

		printPrime(999);
		printSqrt(10);
		System.out.println(isPrime(12));

		checkPrime(1);
		checkPrime(1,2);
		checkPrime(1,2,3);
		checkPrime(1,2,3,4,5);
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

	public static void checkPrime(int... input){
//		Arrays.stream(input).filter(f -> f != 1).filter(ip -> IntStream.rangeClosed(2, ip/2).noneMatch(i -> ip%i == 0)).forEach(System.out::print);

		for(int ip :input){
			boolean isPrime = true;
			if(ip != 1){
				for(int i=2;i<ip;i++){
					if(ip%i == 0)  {
						isPrime = false;
					}
				}
				if(isPrime)
					System.out.print(ip+" ");
			}
		}
		System.out.println();
	}
}


