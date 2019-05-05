package com.bilqu.java8.math;

public class ThreeSum {

	public static void main(String[] args) {

		int[] ip = new int[] {5,3,4,1,2};
		print3Sum(ip,7);
		
	}
	
	public static void print3Sum(int[] ip, int sum) {
		int result = 0;
		for(int i=0;i<ip.length;i++) {
			result = ip[i];
			
			if(i <= i-2)
		
				if(i <= i-3)
			
				if(result == sum)
				{
					System.out.println(ip[i]+":"+ip[i+1]+":"+ip[i+2]);
				}
				
				result =0;
		}
	}
}
