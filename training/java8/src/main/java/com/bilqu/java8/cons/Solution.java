package com.bilqu.java8.cons;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] a){
//            IntStream.rangeClosed(1, 10).filter(i -> i%2 == 0).collect(Collectors.toList());

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

//        IntStream.rangeClosed(1, 10).filter(i -> i %2 != 0).forEach(System.out::println);

        int[] ip = {10,20,20,10,10,30,50,10,20};

        List<Integer> ipList = Arrays.stream(ip).boxed().collect(Collectors.toList());

        for(int i : ip){
            if(ipList.contains(i)){

            }
        }





    }


}
