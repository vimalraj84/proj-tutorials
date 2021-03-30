package com.bilqu.structural.proxy;

public class TestProxyPattern {
    public static void main(String[] args) {
        AccountProxy proxy = new AccountProxy();
        proxy.getTransactions().stream().forEach(System.out::println);
    }
}
