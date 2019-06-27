package com.bilqu.java8.string;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.IntConsumer;

public class LongestWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);String ip = scan.nextLine();
		System.out.println("Finding the longest word in the sentences : "+ip);
		System.out.println(findLongestWord7(ip));
		System.out.println(findLongestWord8(ip));
	}


	public static String findLongestWord7(String ip){
		String[] words = ip.split("\\W");
		String out = null;
		for(String word : words){
			if(out == null) {
				out = word;
			}else{
				if(out.length()<word.length()){
					out = word;
				}
			}
		}
		return out;
	}

	public static Optional findLongestWord8(String ip){
		String[] words = ip.split("\\W");
		Arrays.stream(words).map(i -> i.length()).max(Integer::compareTo).ifPresent(System.out::println);
		return Arrays.stream(words).max(Comparator.comparing(String::length));
	}
}
