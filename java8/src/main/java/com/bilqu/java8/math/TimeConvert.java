package com.bilqu.java8.math;

public class TimeConvert {

    public static void main(String[] a){

        System.out.println(find(126));
        System.out.println(find(138));
        System.out.println(find(25));
        System.out.println(find(1089));
    }

    public static String find(long ip){
        StringBuilder out = new StringBuilder();

        if(ip >60){
            String mins = null;
            if(ip%60 > 0)
                mins = String.valueOf(ip%60);

            String hours = null;

            hours = String.valueOf(ip/60);

            out.append(hours).append(":").append(mins);

        }else{
            out.append(0).append(":").append(ip);
        }
        return out.toString();
    }
}
