package com.bilqu.java8.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctElementCounter {

    public static void main(String[] a){

        int[] ip1 = {10, 20, 20, 10, 30, 10};
        System.out.println(countDistinctElement7(ip1));
        System.out.println(countDistinctElement8(ip1));
    }


    public static long countDistinctElement8(int[] ip){
        List<Integer> out = Arrays.stream(ip).distinct().boxed().collect(Collectors.toList());

        out.stream().forEach(System.out::println);

        return Arrays.stream(ip).distinct().count();
    }


    public static int countDistinctElement7(int[] ip){

        List<Integer> out = new ArrayList<>();

        for(int i : ip){
            if(!out.contains(i))
                out.add(i);
        }
        out.stream().forEach(System.out::println);

        return out.size();
    }

}
