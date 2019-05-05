package com.bilqu.java8.string;

import java.util.Arrays;

public class StringAnagram {

	public static void main(String[] args) {
		String input = "Cinema"; // Peels
		String compare = "Iceman";
		
		char[] ip = input.toUpperCase().toCharArray();
		char[] c = compare.toUpperCase().toCharArray();
		
		Arrays.sort(ip);
		Arrays.sort(c);
		
		System.out.println(Arrays.equals(ip, c));
		
		
	}
	
	
	public static class Stack{
		
		private char[] ip;
		
		//Pushing (storing) an element on the stack. 
		public void push() {
			
		}
		//Removing (accessing) an element from the stack. 
		public void pop() {
			
		}
			
		//get the top data element of the stack, without removing it. 
		public char peek() {
			return 0;
		}
			
		//check if stack is full. 
		public boolean isFull() {
			return false;
			
		}
			
		public boolean isEmpty() {
			return false;
		}
	}
}

