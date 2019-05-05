package com.bilqu.java8.string;

import java.util.stream.IntStream;

public class Palindrome {

    public static void main (String[] a){
        String ip = "dad";
        System.out.println("Input: "+ ip);

        StringBuilder builder = new StringBuilder(ip);
        System.out.println("Is Palindrome: " + builder.reverse().toString().equalsIgnoreCase(ip));
       
        System.out.println("Is Palindrome: " + checkPalindrome(ip));
    }

    public static boolean checkPalindrome(String ip){
        return IntStream
        		.range(0, ip.length() / 2)
        		.noneMatch(i -> ip.charAt(i) != ip.charAt(ip.length() - i - 1));
    }
}
