package com.bilqu.java8.test;

import java.util.stream.IntStream;

public class TestMain {

    public static void main(String[] q){
        IntStream.range(0,5 - 1).flatMap(i -> IntStream.range(1, 4-i)).forEach(System.out::println);
    }

}
