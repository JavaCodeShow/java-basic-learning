package com.jf;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello1");
        new Main().wait();
        System.out.println("hello");
    }
}


