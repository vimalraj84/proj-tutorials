package com.bilqu.java8.math;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ReverseNumber {

	public static void main (String[] a) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		print7(input);
		print8(input);
	}

	public static void print7(int input){
		int output = 0;
		while(input >=9){
			output = output*10+input%10;
			input = input/10;
		}
		output = output*10+input;
		System.out.println("\nOutput : "+output);
	}

	public static void print8(int input){

		if (input != 0){
		}

	}
}
