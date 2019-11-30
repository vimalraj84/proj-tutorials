package com.bilqu.java8.cons;

import java.util.*;
import java.util.stream.Collectors;

public class SpliteratorEx {
    public static void main(String[] args) {
        int[] ip = new int[]{0,23,45,12,67,87};
        System.out.println("Stream");
        Iterator i = Arrays.stream(ip).iterator();

        while(i.hasNext()){
            System.out.println(i.next());
        }

        Spliterator s = Arrays.stream(ip).spliterator();

        while(s.tryAdvance(o -> System.out.println(o)));

        System.out.println("Collection");
        List<Integer> list = Arrays.stream(ip).boxed().collect(Collectors.toList());

        System.out.println(list.size());

        Iterator it = list.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

        Spliterator sit = list.spliterator();

        while(sit.tryAdvance(o -> System.out.println(o)));
    }
}
