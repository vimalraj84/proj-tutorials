package com.bilqu.java8.challenge;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SockPairCounter {

    public static void main(String[] args) {
        final List<Integer> socks = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)){
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String[] ip = scanner.nextLine().split(" ");

            Arrays.stream(ip).forEach(i -> socks.add(Integer.valueOf(i)));
            int out = countPairs(socks);
            System.out.println(out);
        }
    }

    private static int countPairs(List<Integer> input){
      Map<Integer,Long> map = input.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

          Long out = map.entrySet().stream().filter(e -> e.getValue() > 1).collect(Collectors.counting());

      return out.intValue();

    }
}
