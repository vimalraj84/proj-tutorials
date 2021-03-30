package com.bilqu.java8.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Calculator {

    public static void main(String[] args) throws IOException {
        MyCalculator ob = new MyCalculator();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        MathOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}



interface MathOperation {
    boolean compute(int input);
}
class MyCalculator {
    public static boolean checker(MathOperation p, int num) {
        return p.compute(num);
    }

    public MathOperation isPrime(){
        return  input -> IntStream.rangeClosed(2, input/2).noneMatch(i -> input%i == 0);
    }

    public MathOperation isOdd(){
        return input -> IntStream.rangeClosed(1, input).noneMatch(i -> input/2 == 0);
    }

    public MathOperation isPalindrome(){
        return input -> String.valueOf(input).equalsIgnoreCase( new StringBuilder(String.valueOf(input)).reverse().toString());
    }
}