package com.bilqu.java8.math;

import java.util.Arrays;

public class MinMax {

    public static void main (String[] a){
        Arrays.stream(getMinMax7(new int[]{1,2,3,4,5})).forEach(System.out::println);
    }

    public static int[] getMinMax8(int[] ip){

        return null;
    }

    public static int[] getMinMax7(int[] ip){

        Arrays.sort(ip);
        int min = 0 ;
        int max = 0;
        int ipLen = ip.length;
        for(int i = 0 ; i < ipLen -1 ; i++){
            min += ip[i];
            max += ip[ipLen -1 -i];
        }

        return new int[]{min,max};
    }
}
