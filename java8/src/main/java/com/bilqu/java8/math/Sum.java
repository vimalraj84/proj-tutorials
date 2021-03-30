package com.bilqu.java8.math;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Sum {

	public static void main(String[] args) {
		
		System.out.println(IntStream.rangeClosed(1, 20).reduce(1,(op,ip) -> op+ip));
		
		System.out.println(IntStream.rangeClosed(1, 20).reduce(0,(op,ip) -> op+ip));
		
		System.out.println(IntStream.rangeClosed(1, 20).sum());

		//Array Sum
		System.out.println(arraySum(new int[]{1,2,3,4,10,11}));
		System.out.println(arraySum(new int[]{28,34,35,37,40,42}));

		//Using sum()
		System.out.println(IntStream.range(1,10).sum());


		long[] ip = new long[] {1000000001,1000000002,1000000003,1000000004,1000000005};
		bigSum(ip);

	}


	public static int arraySum(int[] ip) {

		return Arrays.stream(ip).reduce((sum,next) -> sum+next).getAsInt();

	}

	public static void bigSum(long[] ip){

		System.out.println(Arrays.stream(ip).sum());
	}


}
