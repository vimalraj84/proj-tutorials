package com.bilqu.java8.utils;

import java.sql.SQLOutput;
import java.util.Base64;
import java.util.Scanner;

public class Base64_Util {

    public static void main (String[] a){

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        System.out.println(new String(Base64.getEncoder().encode(input.getBytes())));

        System.out.println(new String(Base64.getDecoder().decode(Base64.getEncoder().encode(input.getBytes()))));
    }
}
