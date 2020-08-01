package com.jf;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("hello");
            int i = 1 / 0;
            System.out.println("world");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main end");

    }
}