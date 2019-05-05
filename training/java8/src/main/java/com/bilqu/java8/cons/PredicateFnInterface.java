package com.bilqu.java8.cons;

import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateFnInterface {

    public static void main (String... a){

        int[] input = new int[]{1,2,3,4,5,7,8,9,0};
        
        System.out.print("Printing even Number... ");
        Predicate<Integer> evenNumPre = num -> (num %2 ==0);
        print(evenNumPre,input);
        System.out.println("\n------\n");
        
        System.out.print("Printing odd Number... ");
        Predicate<Integer> oddNumPre = num -> (num % 2 >0);
        print(oddNumPre,input);
        System.out.println("\n------\n");
        
        System.out.print("Printing square Number... ");
        Predicate<Integer> sqNumPre = num -> (num > 0);
        print(sqNumPre, input);
        System.out.println("\n------\n");
        
    }
    
    
    public static void print( Predicate<Integer> predicate,int... input) {
    	Arrays.stream(input).forEach(i -> {
            if(predicate.test(i)){
                System.out.print(i+"|");
            }
        });
    }
}
