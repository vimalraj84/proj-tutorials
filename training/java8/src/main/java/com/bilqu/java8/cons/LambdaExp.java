package com.bilqu.java8.cons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaExp {

    public static void main(String[] a){

        int[] input = {1,2,3,4,5,6,7,8,9,10};


        // IntStream (along with the other primitive streams) does not have a collect(Collector) method.
        // Its collect method is: collect(Supplier,ObjIntConsumer,BiConsumer).

        //So this will not work
        // List<Integer> out = Arrays.stream(input).map(l -> l*l).collect(Collectors.toList());

        //So we need to use auto boxing
        List<Integer> out = Arrays.stream(input).map(l -> l*l).boxed().collect(Collectors.toList());

        //OR we can
        List<Integer> out1 = Arrays.stream(input).map(l -> l*l).collect(ArrayList::new, List::add, List::addAll);
        out1.forEach(System.out::println);

        // takes a Long, returns a String
        Function<Long, String> f = l -> l.toString();

        Arrays.stream(input).map(l -> l*l).forEach(System.out::println);

        // takes nothing gives you Threads
        Supplier<Thread> s =Thread::currentThread;

        System.out.println(s);

        // takes a string as the parameter
        Consumer<String> c = System.out::println;

        System.out.println( c );

    }
}
