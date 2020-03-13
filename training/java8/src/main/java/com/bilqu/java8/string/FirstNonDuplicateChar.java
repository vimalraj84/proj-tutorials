package com.bilqu.java8.string;

import java.util.Arrays;
import java.util.Collections;

public class FirstNonDuplicateChar {

    public static void main(String[] args) {
        System.out.println("daddy : " + findChar("daddy"));
        System.out.println("anna : "+findChar("anna"));
    }

    public static char findChar(String s){
        char[] c_ip = s.toCharArray();
        Arrays.sort(c_ip);

        for(int i = 0; i < c_ip.length -1 ;i++){
            if(c_ip[i] != c_ip[i+1]) {
                return c_ip[i];
            }
        }
        return 0;
    }
}
