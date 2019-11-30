package com.bilqu.java8.cons;

@FunctionalInterface
public interface FunInterface {

    int process();

    default void  convert(){
        System.out.println("Default Method convert()");
    }

    static void util1(){
        System.out.println("Static Method util()");
    }

    static void util2(){
        System.out.println("Static Method util()");
    }

}
