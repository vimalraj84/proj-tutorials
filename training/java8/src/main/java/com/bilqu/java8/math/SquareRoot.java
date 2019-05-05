package com.bilqu.java8.math;

import java.util.Scanner;

public class SquareRoot {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        System.out.println("Enter Input: ");
      
        double input = scanner.nextDouble();
      
        double squareRoot = Math.sqrt(input);
      
        System.out.printf("Square root of : %f is : %f %n" , input, squareRoot);
        
        System.out.printf("Square root of : %f is : %f %n" , input, getSqrt(input));

	}
	
	public static double getSqrt(double ip) {
		if (ip == 0 || ip == 1) 
		    return ip; 
		double square = 1; 
		for( int i = 0; i < ip; i++)
		  {
			square = 0.5*( square+ ip/square );
		  }
		return square;
	}

}
