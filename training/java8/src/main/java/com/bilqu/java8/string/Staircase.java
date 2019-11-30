package com.bilqu.java8.string;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Staircase {

    public static void main (String[] a){

        try(Scanner scanner = new Scanner(System.in)){
            int input = scanner.nextInt();
            System.out.println(String.format("Input is %s \0",input));
            //printStaircase8(input);
            printStaircase7(input);
        }
    }

    public static void printStaircase8(int ip){
        IntStream.rangeClosed(1,ip).forEach(i -> System.out.println(String.format("%"+(ip-i)+"s","?")));
    }

    public static void printStaircase7(int ip){
        for(int i = 1; i <= ip; i++){
            if(i != ip)
                System.out.print(String.format("%"+(ip-i)+"s"," "));
            System.out.print(new String(new char[i]).replace("\0","#"));
            System.out.println();
        }
    }
}
