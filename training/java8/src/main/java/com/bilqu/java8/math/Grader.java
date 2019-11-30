package com.bilqu.java8.math;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Grader {
    public static void main(String[] a){

        gradingStudents(Arrays.asList(new Integer[] {73,67,38,33})).stream().forEach(System.out::println);

    }

    public static List<Integer> gradingStudents(List<Integer> grades) {

        return grades.stream().map(i -> {
            if(i >= 38){
                int rem = 5 - (i.intValue()%5);
                if(rem < 3){
                   return (i +rem) ;
                }
            }
            return i;
        }).collect(Collectors.toList());
    }
}
