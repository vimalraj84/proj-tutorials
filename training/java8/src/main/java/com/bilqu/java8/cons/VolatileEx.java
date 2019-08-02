package com.bilqu.java8.cons;

public class VolatileEx {

    private volatile int count = 0;

    public void increamenter() {
        count++;
    }
    public int getCount() {
        return count;
    }
    public static void main(String[] a){
        VolatileEx volatileEx = new VolatileEx();
        volatileEx.increamenter();
        System.out.println(volatileEx.getCount());
    }
}
