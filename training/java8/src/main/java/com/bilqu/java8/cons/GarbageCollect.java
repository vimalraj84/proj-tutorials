package com.bilqu.java8.cons;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class GarbageCollect {

    public static void main (String[] a){
        //Strong reference
        StringBuilder sb = new StringBuilder();
        sb = null;

        //SoftReference
        StringBuilder sb1 = new StringBuilder();
        SoftReference<StringBuilder> sbRef = new SoftReference<>(sb1);
        sb1 = null;

        //WeakReference
        StringBuilder sb2 = new StringBuilder();
        WeakReference <StringBuilder> sbwRef = new WeakReference<>(sb2);
        sb2 = null;

        //phantomReference

    }
}
