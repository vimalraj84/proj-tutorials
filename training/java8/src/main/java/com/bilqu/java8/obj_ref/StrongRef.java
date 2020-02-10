package com.bilqu.java8.obj_ref;

import java.lang.ref.SoftReference;


public class StrongRef {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("SoftReference");
        SoftReference<StringBuilder> sbSoftRef = new SoftReference<>(sb);

    }


}
