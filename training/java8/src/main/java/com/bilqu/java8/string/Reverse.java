package com.bilqu.java8.string;

import java.util.stream.IntStream;

public class Reverse {

	public static void main(String[] args) {
		String input = "Laptop";


		System.out.println(inverse7(input));

		System.out.println(inverse8(input));

		char[] ip = input.toCharArray();
		String output = flipper(ip);
		System.out.println(input+" : "+output);



		
	}


	public static String inverse7(String ip){
		StringBuilder out =new StringBuilder();
		for(int i =ip.length()-1 ; i >= 0;i--){
			out.append(ip.charAt(i));
		}
		return out.toString();
	}


	public static String inverse8(String ip){


		System.out.println(IntStream.range(0,ip.length())
				.map(i -> ip.charAt(ip.length() - i -1))
				.collect(StringBuilder::new, (builder,c) -> builder.append((char)c),StringBuilder::append).toString());


		StringBuilder out =new StringBuilder();
		IntStream.range(0,ip.length())
				.map(i -> ip.charAt(ip.length() - i -1)).forEach(c -> out.append((char)c));
		return out.toString();


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
