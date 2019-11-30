package com.bilqu.java8.concur;

import java.util.stream.IntStream;

public class ThreadScope {

    public static void main(String[] a){

        ScopeRunnable threadRunnable = new ThreadScope().new ScopeRunnable();

        IntStream.range(0,5).forEach(i -> new Thread(threadRunnable).start());
    }


    public class ScopeRunnable implements Runnable{

        private ThreadLocal threadName = new ThreadLocal<String>();

        @Override
        public void run() {
            threadName.set("The Executing Thread is : "+ Thread.currentThread().getName());
            System.out.println(threadName.get());
        }
    }

}
