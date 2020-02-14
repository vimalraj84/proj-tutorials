package com.bilqu.java8.math;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Fibonacci {

    public static void main(String[] a){

        withJava7();
        withJava8();
        withJava8Suplier();
    }

    public static void withJava7(){
        System.out.println("Fibonacci with Java 7");
        //Old
        long limit = 10;
        long prev,curr,next = 0;

        curr = 1;
        prev = 0;
        for (int i =0; i < limit ; i++) {
            System.out.println(prev);
            next = prev+curr;
            prev = curr;
            curr = next;
        }
    }

    public static void withJava8Suplier(){
        System.out.println("Fibonacci with Java 8 supplier");
        int[] fib = {0,1};
        Stream<Integer> fibSeries = Stream.generate(()->{
            int result = fib[1];
            int next = fib[0]+fib[1];
            fib[0]=fib[1];
            fib[1]=next;
            return result;
        }).limit(10);
        fibSeries.forEach(System.out::println);
    }

    public static void withJava8(){
        System.out.println("Fibonacci with Java 8");
        Stream.iterate(new long[]{ 0, 1 }, p -> new long[]{ p[1], p[0]+p[1] }).limit(10).forEach(p -> System.out.println(p[0]));

        Stream.iterate(new int[]{ 0, 1 }, p -> new int[]{ p[1], p[0]+p[1] }).limit(10).forEach(p -> System.out.println(p[0]));
    }
}
