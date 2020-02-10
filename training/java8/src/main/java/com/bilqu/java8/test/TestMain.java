package com.bilqu.java8.test;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class TestMain {
    public static void main(String[] args) {


        List<String> stringList = new ArrayList<String>();

        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("one");

        Stream<String> stream1 = stringList.stream();

        Optional<String> result = stream1.findFirst();

        System.out.println(result.get());

        Stream<String> stream2 = stringList.stream();
        Optional<String> result1 = stream2.findAny();

        System.out.println(result1.get());



        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream = stringList.stream();

        stream.flatMap((value) -> {
            String[] split = value.split(" ");
            return (Stream<String>) Arrays.asList(split).stream();
        })
                .forEach((value) -> System.out.println(value))
        ;

        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", s -> s.length()*10);
        System.out.println(value);
        System.out.println(nameMap);
        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";

        Function<Integer, String> quoteIntToString = quote.compose(intToString);

        System.out.println(quoteIntToString.apply(5));

        nameMap.put("Anna", 300);
        nameMap.put("Mia", 310);
        nameMap.put("Jenifer", 350);
        nameMap.put("Cory", 380);

        System.out.println(nameMap);


        nameMap.replaceAll((name,num)->name.equals("Anna") ? num+10:num);

        System.out.println(nameMap);
    }


}