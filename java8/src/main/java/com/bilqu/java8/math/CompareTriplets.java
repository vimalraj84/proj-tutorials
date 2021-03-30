package com.bilqu.java8.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompareTriplets {

    public static void main(String[] ip) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> a = Stream.of(bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> b = Stream.of(bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = compareInput(a, b);

        result.stream().forEach(System.out::println);

        bufferedReader.close();
    }

    public static List<Integer> compareInput(List<Integer> ip1, List<Integer> ip2){

//      ip1.stream().filter(i1 -> (ip2.stream().map(i2 -> i2.compareTo(i1) > 1 ? 1 :  ));

        int out1 = 0;
        int out2 = 0;

        if(ip1 != null && !ip1.isEmpty() && ip2 != null && !ip2.isEmpty() && ip1.size() == ip2.size()){
            for(int i=0; i<ip1.size();i++){
                if(ip1.get(i).compareTo(ip2.get(i)) > 0){
                    out1++;
                }else if(ip1.get(i).compareTo(ip2.get(i)) < 0){
                    out2++;
                }
            }
        }
        List<Integer> output = new ArrayList<>();
        output.add(out1);
        output.add(out2);
        return output;
    }
}
