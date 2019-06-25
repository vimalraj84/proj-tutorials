package com.bilqu.java8.cons;

import java.math.BigDecimal;
import java.util.function.DoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;

public class BiFunctionEx {

    public static void main (String[] a){
        //Takes in two arguments of type T and U and produces an int-valued result.
        ToIntBiFunction<Integer, BigDecimal> toInt = (ip1,ip2) -> ((ip1*ip1) + ((ip2.multiply(ip2).multiply(ip2)).intValue()));

        System.out.println(toInt.applyAsInt(3, BigDecimal.valueOf(7)));


        ToLongBiFunction<Integer, BigDecimal> toLong = (ip1, ip2) -> ((ip1*ip1) + ((ip2.multiply(ip2).multiply(ip2)).longValue()));
        System.out.println(toLong.applyAsLong(3, BigDecimal.valueOf(7)));


        DoubleFunction<Double> dobFunc = ip -> (ip*ip);

        System.out.println(dobFunc.apply(10));


    }
}
