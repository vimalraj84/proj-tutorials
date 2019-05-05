package com.bilqu.java8.math;

import java.util.stream.Stream;

public class Fibonacci {

    public static void main(String[] a){

        withJava7();
        withJava8();
    }

    public static void withJava7(){
        System.out.println("Fibonacci with Java 7");
        //Old
        long limit = 10;
        long prev,curr,next = 0;
        long startVal = 1;

        System.out.println(0);
        System.out.println(1);
        curr = 1;
        prev = 0;
        for (int i =0; i < limit ; i++) {
            next = prev+curr;
            System.out.println(next);
            prev = curr;
            curr = next;
        }
    }

    public static void withJava8(){
        System.out.println("Fibonacci with Java 8");
        Stream.iterate(new long[]{ 0, 1 }, p -> new long[]{ p[1], p[0]+p[1] }).limit(10).forEach(p -> System.out.println(p[0]));
    }
}
