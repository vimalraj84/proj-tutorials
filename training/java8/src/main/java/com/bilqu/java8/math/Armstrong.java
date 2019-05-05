package com.bilqu.java8.math;

import java.util.stream.IntStream;

public class Armstrong {

	public static void main(String[] args) {
		System.out.println(armstrongNum(153));
		generateArmstrongNum(999999999).forEach(System.out::println);
	}

	//A number is called an Armstrong number if it is equal to the cube of its each digit. 
	// for example, 153 is an Armstrong number because 153= 1+ 125+27 which is equal to 1^3+5^3+3^3. 
	public static boolean armstrongNum(int n) {
		return String.valueOf(n).chars().map(i -> Character.getNumericValue(i)).map(i->(i*i*i)).sum() == n ;
	}
	
	public static IntStream generateArmstrongNum(int range) {
		return IntStream.range(0,range).filter(Armstrong::armstrongNum);
	}
}
