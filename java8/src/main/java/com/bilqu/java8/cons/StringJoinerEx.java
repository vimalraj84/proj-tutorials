package com.bilqu.java8.cons;

import java.util.StringJoiner;

public class StringJoinerEx {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(",");
        sj.add("Friday").add("Saturday");
        System.out.println(sj);

    }
}
