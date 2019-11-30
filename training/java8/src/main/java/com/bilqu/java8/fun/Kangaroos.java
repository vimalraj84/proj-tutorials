package com.bilqu.java8.fun;

public class Kangaroos {

    public static void main(String[] a){

        System.out.println(jumpKangaroos(0,3,4,2));
        System.out.println(jumpKangaroos(0,2,5,3));
    }

    public static String jumpKangaroos(int x1, int v1, int x2, int v2) {
        int k1_loc = 0;
        int k2_loc = 0;
        int k1_jmp = 0;
        int k2_jmp = 0;

        if(x2 > x1  && v2 > v1){
            return "NO";
        }else if(x1 > x2  && v1 > v2){
            return "NO";
        }

        while(k1_loc != k2_loc && k1_jmp != k2_jmp){
            k1_loc += (x1+v1);
            k1_jmp ++;
            k2_loc += (x2+v2);
            k2_jmp++;
        }
        return "YES";
    }

}
