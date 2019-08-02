package com.bilqu.java8.math;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListIntersect {

    public static void main(String[] a){
        List<Integer> ip1 = IntStream.range(1,9).boxed().collect(Collectors.toList());
        List<Integer> ip2 = IntStream.range(4,8).boxed().collect(Collectors.toList());

        List<Integer> out = ip1.stream().filter(ip2::contains).collect(Collectors.toList());

        out.stream().forEach(System.out::println);

    }
}
