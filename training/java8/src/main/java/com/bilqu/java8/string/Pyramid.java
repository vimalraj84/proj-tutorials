package com.bilqu.java8.string;

import java.util.stream.IntStream;

public class Pyramid {

    public static void main (String[] a){
        printPyramid(10);
        printInvertedPyramid(10);
        printTriangle(10);
        printTriangle2(10);
    }

    public static void printPyramid(int ip)
    {
        IntStream.range(0,ip).forEach(i -> {
            // number of spaces before printing
            IntStream.range(1, ip-i).forEach(noOfSpace ->{
                System.out.print(" ");
            });
            //  handle number of columns
            IntStream.range(0,i).forEach(noOfstar ->{
                // printing numbers
                System.out.print(i);
                //Insert space after each numbers
                System.out.print(" ");
            });
            // new line line after each row
            System.out.println();
        });
        System.out.println();
    }

    public static void printInvertedPyramid(int ip)
    {
        IntStream.range(0,ip).map(i -> ip - i + 0 - 1).forEach(i -> {
            // number of spaces before printing
            IntStream.range(1, ip-i).forEach(noOfSpace ->{
                System.out.print(" ");
            });
            //  handle number of columns
            IntStream.range(0,i).forEach(noOfstar ->{
                // printing numbers
                System.out.print(i);
                //Insert space after each numbers
                System.out.print(" ");
            });
            // new line line after each row
            System.out.println();
        });
        System.out.println();
    }

    public static void printTriangle(int ip)
    {
        IntStream.range(0,ip).forEach(i -> {
            //  handle number of columns
            IntStream.range(0,i).forEach(noOfstar ->{
                // printing numbers
                System.out.print(i);
                //Insert space after each numbers
                System.out.print(" ");
            });
            // new line line after each row
            System.out.println();
        });
        System.out.println();
    }

    public static void printTriangle2(int ip)
    {
        IntStream.range(0,ip).map(i -> ip - i + 0 - 1).forEach(i -> {

            //  handle number of columns
            IntStream.range(0,i).forEach(noOfstar ->{
                // printing numbers
                System.out.print(i);
                //Insert space after each numbers
                System.out.print(" ");
            });
            // new line line after each row
            System.out.println();
        });
        System.out.println();
    }
}
