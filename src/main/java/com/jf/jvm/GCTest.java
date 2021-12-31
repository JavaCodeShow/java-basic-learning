package com.jf.jvm;

/**
 * @author 江峰
 * @create 2020-03-01   11:39
 */
public class GCTest {

    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[40000 * 1024];
        allocation2 = new byte[9000 * 1024];
    }
}