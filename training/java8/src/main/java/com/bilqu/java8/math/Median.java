package com.bilqu.java8.math;

import java.util.Arrays;

public class Median {

	public static void main(String[] args) {
		 
		int[] ip1 = new int[] {5,8,3,7,2,4,9};
		int[] ip2 = new int[] {4,1,9,5,3,7};
		
		System.out.println("\n Median : "+getMedian(ip1));
		System.out.println("\n Median : "+getMedian(ip2));
		
	}
	
	public static int getMedian(int[] ip) {
		
		Arrays.sort(ip);
		Arrays.stream(ip).forEach(System.out::print);
		if(ip.length % 2 == 0) {
			int index = ip.length/2;
			return (ip[index]+ip[index-1])/2;
		}else {
			return ip[ip.length/2];
		}
	}

}
