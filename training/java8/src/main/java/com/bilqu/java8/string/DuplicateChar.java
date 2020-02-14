package com.bilqu.java8.string;

import java.io.CharArrayReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class DuplicateChar {

    public static void main(String[] a){
        String input = "Character";
        findDuplicate(input);
    }

    public static void findDuplicate(String ip){

        IntStream.range(0,ip.length()).filter(i -> ip.charAt(i) == ip.charAt(ip.length() -i -1)).forEach( o -> System.out.println(o));



    }
}
