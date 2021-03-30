package com.bilqu.java8.cons;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;

public class BiFunctionEx {

    public static void main (String[] a){

        Map<String, Integer> nameMap = new HashMap<>();
        nameMap.put("John", 350);
        nameMap.put("Anna", 300);
        nameMap.put("Mia", 310);
        nameMap.put("Jenifer", 350);
        nameMap.put("Cory", 380);

        System.out.println(nameMap);
        nameMap.replaceAll((name,num)->name.equals("Anna") ? num+10:num);
        System.out.println(nameMap);

        //Takes in two arguments of type T and U and produces an int-valued result.
        ToIntBiFunction<Integer, BigDecimal> toInt = (ip1,ip2) -> ((ip1*ip1) + ((ip2.multiply(ip2).multiply(ip2)).intValue()));
        System.out.println(toInt.applyAsInt(3, BigDecimal.valueOf(7)));


        ToLongBiFunction<Integer, BigDecimal> toLong = (ip1, ip2) -> ((ip1*ip1) + ((ip2.multiply(ip2).multiply(ip2)).longValue()));
        System.out.println(toLong.applyAsLong(3, BigDecimal.valueOf(7)));


        DoubleFunction<Double> dobFunc = ip -> (ip*ip);
        System.out.println(dobFunc.apply(10));


    }
}
