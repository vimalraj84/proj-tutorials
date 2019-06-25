package com.bilqu.java8.cons;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerEx {

    public static void main(String[] a){
        List<Integer> intLst1 = Arrays.asList(new Integer[]{23,45,67,12,76});

        List<Integer> intLst2 = Arrays.asList(new Integer[]{43,15,87,32,96});

        BiConsumer<List<Integer>, List<Integer>> biConsumer = (list1,list2) -> {
            if(list1.size() == list2.size()) {
                System.out.println("Both list are of the same size");
            } else {
                System.out.println("Both list have different size");
            }
            return;
        };

        biConsumer.accept(intLst1,intLst2);
    }
}
