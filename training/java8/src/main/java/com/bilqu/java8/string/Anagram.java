package com.bilqu.java8.string;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String input = "Cinema"; // Peels
		String compare = "Iceman";
		
		char[] ip = input.toUpperCase().toCharArray();
		char[] c = compare.toUpperCase().toCharArray();
		
		Arrays.sort(ip);
		Arrays.sort(c);
		
		System.out.println(Arrays.equals(ip, c));
		
		
	}
}

