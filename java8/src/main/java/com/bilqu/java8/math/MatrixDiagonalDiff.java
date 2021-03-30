package com.bilqu.java8.math;

import java.util.ArrayList;
import java.util.List;

public class MatrixDiagonalDiff {

    public static void main (String[] a){

        List<List<Integer>> ip = new ArrayList<>();

        List<Integer> ip1 = new ArrayList<>();
        ip1.add(11);
        ip1.add(2);
        ip1.add(4);

        List<Integer> ip2 = new ArrayList<>();
        ip2.add(4);
        ip2.add(5);
        ip2.add(6);

        List<Integer> ip3 = new ArrayList<>();
        ip3.add(10);
        ip3.add(8);
        ip3.add(-12);

        ip.add(ip1);
        ip.add(ip2);
        ip.add(ip3);

        System.out.println(diagDiff(ip));
    }

    private static int diagDiff(List<List<Integer>> arr){

        int leftSum = 0;
        int rightSum = 0;

        if(arr == null || arr.isEmpty() )
            return 0;
        int size =arr.size();

        for(int i =0 ; i <size ;i ++){
            leftSum += arr.get(i).get(i);
            rightSum += arr.get(i).get(size-1-i);
        }

        return Math.abs(leftSum-rightSum);
    }
}
