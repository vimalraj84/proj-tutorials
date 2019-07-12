package com.bilqu.java8.string;

import java.util.stream.IntStream;

public class Palindrome {

    public static void main (String[] a){
        String ip = "dad";
        System.out.println("Input: "+ ip);

        StringBuilder builder = new StringBuilder(ip);
        System.out.println("Is Palindrome: " + builder.reverse().toString().equalsIgnoreCase(ip));
       
        System.out.println("Is Palindrome: " + checkPalindrome8(ip));
        System.out.println("Is Palindrome: " + checkPalindrome7(ip));
    }

    public static boolean checkPalindrome8(String ip){
        return IntStream
        		.range(0, ip.length() / 2)
        		.noneMatch(i -> ip.charAt(i) != ip.charAt(ip.length() - i - 1));
    }

    public static boolean checkPalindrome7(String ip){

        for(int i =0; i< ip.length()/2; i++){
            if(ip.charAt(i) != ip.charAt(ip.length() -i -1)){
                return false;
            }
        }
        return true;

    }
}
