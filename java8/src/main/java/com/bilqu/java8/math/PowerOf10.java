package com.bilqu.java8.math;

public class PowerOf10 {

    public static void main(String[] args) {
        System.out.println(isLog10(0));
        System.out.println(isLog10(1));
        System.out.println(isLog10(10));
        System.out.println(isLog10(100));
        System.out.println(isLog10(1000));
        System.out.println(isLog10(10000));
        System.out.println(isLog10(100000));
        System.out.println(isLog10(20));
        System.out.println(isLog10(31));
    }

    private static boolean isLog10(int input){

        while(true){
            if(input == 0 )
                return false;

            else if(input ==1)
                return true;
            input /=10;
        }

    }

    private static int isLog10_rec(int input){

        if(input == 0 )
            return 0;

        else if(input ==1)
            return 1;

        else
            return isLog10_rec(input/10);
    }
}
