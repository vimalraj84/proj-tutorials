package com.bilqu.java8.fun;

import java.util.Arrays;
import java.util.Optional;

public class ArraySortWave {

    public static void main(String[] args) {
        int[] test1 = new int[]{15,5,30,25,10,20};
        Arrays.stream(sortWave(test1).get()).forEach(System.out::print);
    }

    public static Optional<int[]> sortWave(int[] input){
        if(input == null)
            return null;

        int[] sorted = new int[input.length];

        Arrays.sort(input);

       for(int i=0;i<input.length - 1;i+=2){
           sorted[i] = input[i +1];
           sorted[i+1] = input[i];
       }
        return Optional.of(sorted);
    }

}
