package com.jf;

/**
 * @author 潇潇暮雨
 * @create 2019-06-15   15:58
 */
public class Singleton {
    // 因为是static，所以这个代码只会执行一次。
    private final static Singleton singleton = new Singleton();

    private Singleton() {

    }

    public static Singleton getSingleton() {
        return singleton;
    }
}

class A {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        Singleton singleton1 = Singleton.getSingleton();
        System.out.println(singleton == singleton1);
    }
}


class C {
    public static void main(String[] args) {

        // for (int i = 0; i < 5; i++) {
        //     new Thread(){
        //         int j = 0;
        //         public void run() {
        //
        //             while (true) {
        //                 System.out.println(j++);
        //             }
        //         }
        //     }.start();
        // }
        Integer a = 1;
        Integer b = 2;
        int i = a.compareTo(b);
        System.out.println(i);
    }
}

