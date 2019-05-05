package com.bilqu.java8.math;

import java.util.Scanner;

public class NumberPalindrome {
	
	public static void main (String[] a) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		System.out.println(isPalindrome(input));
	}
	
	public static boolean isPalindrome(int ip) {
		
		int input = ip;
		
		if(input < 0 || (input % 10 == 0 && input != 0))
			return false;
		
		int output = 0;
		while(input >9){
			output = output*10+input%10;
			input = input/10;
		}
		output = output*10+input;
		System.out.println("\nOutput : "+output);
		if(ip == output)
            return true;
        else 
            return false;
	}
	
}
