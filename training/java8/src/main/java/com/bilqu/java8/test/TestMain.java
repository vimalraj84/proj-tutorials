package com.bilqu.java8.test;


import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain {
    public static void main(String[] args) {

        String[] products = new String[] { "Apple", "Computer", "Apple", "Bag"  };
        String unique = null;
        for(int i =0; i< products.length; i++){

            unique = products[i];

            for(int j = i+1 ; j < products.length ; j ++){
                System.out.println(unique +"->"+products[j]);
                if(unique.equalsIgnoreCase(products[j])){
                    unique = null;
                    break;
                }
            }
            if(unique != null) {
                System.out.println(unique);
                break;
            }
            else
                continue;
        }

//        String test= "hello1";
//        StringBuilder sb = new StringBuilder(test).reverse();
//
//        char[] ch = test.toCharArray();
//        int len = ch.length;
//        int mid = ch.length/2;
//        char temp;
//        for ( int i =0; i<(len/2);i++){
//            temp = ch[i];
//            ch[i] = ch[(len -1)  - i];
//            ch[(len -1) - i] = temp;
//            System.out.println(ch[i] +"->"+ ch[len -1 -i]);
//        }
//        for(char c :ch)
//            System.out.print(c);
//
//
//////////------------------
//        String input = "words and 987";
//
//        if(input.matches("^[A-Za-z]+"))
//            System.out.println(0);
//        input = input.replaceAll("[^-+0-9]","");
//        System.out.println(Integer.valueOf(input));
////        Arrays.stream(ip).filter(i -> i != null && !i.isEmpty()).forEach(i -> System.out.print(i+","));
////        Arrays.stream(ip).filter(i -> i != null && !i.isEmpty()).filter(i -> i.matches("^-?(\\d)*")).map(Integer::valueOf).forEach(System.out::println);
//
//        //--------------------------
//
//        List<String> stringList = new ArrayList<String>();
//
//        stringList.add("one");
//        stringList.add("two");
//        stringList.add("three");
//        stringList.add("one");
//
//        Stream<String> stream1 = stringList.stream();
//
//        Optional<String> result = stream1.findFirst();
//
//        System.out.println(result.get());
//
//        Stream<String> stream2 = stringList.stream();
//        Optional<String> result1 = stream2.findAny();
//
//        System.out.println(result1.get());
//
//
//
//        stringList.add("One flew over the cuckoo's nest");
//        stringList.add("To kill a muckingbird");
//        stringList.add("Gone with the wind");
//
//        Stream<String> stream = stringList.stream();
//
//        stream.flatMap((value) -> {
//            String[] split = value.split(" ");
//            return (Stream<String>) Arrays.asList(split).stream();
//        })
//                .forEach((value) -> System.out.println(value))
//        ;
//
//        Map<String, Integer> nameMap = new HashMap<>();
//        Integer value = nameMap.computeIfAbsent("John", s -> s.length()*10);
//        System.out.println(value);
//        System.out.println(nameMap);
//        Function<Integer, String> intToString = Object::toString;
//        Function<String, String> quote = s -> "'" + s + "'";
//
//        Function<Integer, String> quoteIntToString = quote.compose(intToString);
//
//        System.out.println(quoteIntToString.apply(5));
//
//        nameMap.put("Anna", 300);
//        nameMap.put("Mia", 310);
//        nameMap.put("Jenifer", 350);
//        nameMap.put("Cory", 380);
//
//        System.out.println(nameMap);
//
//
//        nameMap.replaceAll((name,num)->name.equals("Anna") ? num+10:num);
//
//        System.out.println(nameMap);
    }


}