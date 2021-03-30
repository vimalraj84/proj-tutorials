package com.bilqu.java8.fun;

public class IpValidator {

    public static void main(String[] a){
//        String ipRegex = "\\b(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5]).\\b";
        String ipRegex2 = "^((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)$";

//        System.out.println("198.23.54.123".matches(ipRegex));

        System.out.println("198.23.54.123".matches(ipRegex2));


    }
}
