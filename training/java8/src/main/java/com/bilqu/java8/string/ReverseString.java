package com.bilqu.java8.string;

public class ReverseString {

	public static void main(String[] args) {
		String input = "Laptop";
		
		char[] ip = input.toCharArray();
		
		String output = flipper(ip);
		System.out.println(input+" : "+output);
		
	}
	
	public static String flipper(char[] ip) {
		if(ip == null || ip.length <=0)
			return null;
		char temp;
		int len = ip.length-1;
		for(int i = 0 ; i<len/2; i++) {
			if(ip[i] != ip[len-i]) {
				temp = ip[i];
				ip[i] = ip[len-i];
				ip[len-i] = temp;
			}
		}
		return String.copyValueOf(ip);
	}
	
}
