package com.jf.singleton;

/**
 * 线程安全的单例模式
 */
public class Singleton {

    private static volatile Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}

