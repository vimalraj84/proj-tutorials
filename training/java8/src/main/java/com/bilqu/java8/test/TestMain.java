package com.bilqu.java8.test;

import com.bilqu.java8.math.Prime;

import java.util.stream.IntStream;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;

import static java.lang.System.in;

public class TestMain {
    public static void main(String[] args)
    {
        PriorityQueue queue =
                new PriorityQueue();
        queue.add(11);
        queue.add(4);
        queue.add(22);
        queue.add(5);
        queue.add(12);
        queue.add(2);

        while (queue.isEmpty() == false)
            System.out.printf("%d ", queue.remove());

        System.out.println("\n");

//        System.out.println( new I1() {
//            String toString()
//            {
//                System.out.print("Example");
//                return("A");
//            }
//        });


//        try
//        {
//            System.out.println(1/0);
//        }
    }

}

interface I1
{
    String toString();
}


