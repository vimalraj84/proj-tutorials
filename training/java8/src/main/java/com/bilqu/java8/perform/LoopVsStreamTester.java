package com.bilqu.java8.perform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LoopVsStreamTester {

    public static void main (String[] a){
        getArrayPerformance();
        getListPerformance();
    }

    public static void getArrayPerformance(){
        System.out.println("\nLIST ARRAY...................");
        int[] ip = IntStream.range(0,100000).toArray();

        List<Integer> out = new ArrayList<>();
        //Index
        long indexLoopStart =  System.currentTimeMillis();
        for(int i =0 ; i<ip.length;i++){
            if(ip[i] % 2 ==  0)
                out.add(i);
        }
        long indexLoopEnd =  System.currentTimeMillis();
        System.out.println("Time Taken to Loop with Index : " + (indexLoopEnd - indexLoopStart));
        out = new ArrayList<>();

        //For Each
        long forEachStart =  System.currentTimeMillis();
        for(int i : ip){
            if(i % 2 ==  0)
                out.add(i);
        }
        long forEachEnd =  System.currentTimeMillis();
        System.out.println("Time Taken with For Each : " + (forEachEnd - forEachStart));
        out = new ArrayList<>();

        //Stream
        long streamStart =  System.currentTimeMillis();
        out = Arrays.stream(ip).filter(i -> i%2== 0).boxed().collect(Collectors.toList());
        long streamEnd =  System.currentTimeMillis();
        System.out.println("Time Taken with Stream : " + (streamEnd - streamStart));
        out = new ArrayList<>();

        //Parallel Stream
        long parallelStreamStart =  System.currentTimeMillis();
        out = Arrays.stream(ip).parallel().filter(i -> i%2== 0).boxed().collect(Collectors.toList());
        long parallelStreamEnd =  System.currentTimeMillis();
        System.out.println("Time Taken with Parallel Stream : " + (parallelStreamEnd - parallelStreamStart));
    }

    public static void getListPerformance(){
        System.out.println("\nLIST PERFORMANCE...................");
        List<Integer> ip = IntStream.range(0,100000).boxed().collect(Collectors.toList());

        List<Integer> out = new ArrayList<>();

        //Index
        long indexLoopStart =  System.currentTimeMillis();
        for(int i =0 ; i<ip.size();i++){
            if(ip.get(i) % 2 ==  0)
                out.add(i);
        }
        long indexLoopEnd =  System.currentTimeMillis();
        System.out.println("Time Taken to Loop with Index : " + (indexLoopEnd - indexLoopStart));
        out = new ArrayList<>();

        //For Each
        long forEachStart =  System.currentTimeMillis();
        for(int i : ip){
            if(i % 2 ==  0)
                out.add(i);
        }
        long forEachEnd =  System.currentTimeMillis();
        System.out.println("Time Taken with For Each : " + (forEachEnd - forEachStart));
        out = new ArrayList<>();

        //Stream
        long streamStart =  System.currentTimeMillis();
        out = ip.stream().filter(i -> i%2== 0).collect(Collectors.toList());
        long streamEnd =  System.currentTimeMillis();
        System.out.println("Time Taken with Stream : " + (streamEnd - streamStart));
        out = new ArrayList<>();

        //Parallel Stream
        long parallelStreamStart =  System.currentTimeMillis();
        out = ip.stream().parallel().filter(i -> i%2== 0).collect(Collectors.toList());
        long parallelStreamEnd =  System.currentTimeMillis();
        System.out.println("Time Taken with Parallel Stream : " + (parallelStreamEnd - parallelStreamStart));
    }

}
