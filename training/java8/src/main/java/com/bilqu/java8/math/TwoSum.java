package com.bilqu.java8.math;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		int[] ip = new int[] {2,7,11,15};
		int[] op = getTwoSum(ip,9);
		
		Arrays.stream( op).forEach(System.out::println);

	}
	
	
	public static int[] getTwoSum(int[] ip,int sum) {
		
		for(int i =0 ; i < ip.length ; i++) {
			
			for(int j = i+1; j<ip.length;j++) {
				if(ip[i]+ip[j] == sum) {
					return new int[] {ip[i],ip[j] };
				}
			}
		}
		
		return null;
	}

}
