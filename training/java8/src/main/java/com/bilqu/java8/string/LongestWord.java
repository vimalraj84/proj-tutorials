package com.bilqu.java8.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LongestWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);String ip = scan.nextLine();
		
		System.out.println("Finding the longest word in the sentences : "+ip);
		
		String[] words = ip.split("\\W");
		
//		System.out.println(Arrays.stream(words).map(i -> i.length)).max(Comparator.comparing(Integer::valueOf)).get();
		
		

	}

}
