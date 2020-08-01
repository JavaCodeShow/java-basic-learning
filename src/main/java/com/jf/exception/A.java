package com.jf.exception;

/**
 * @author 江峰
 * @create 2019-11-04   10:24
 */
public class A {
    public static void main(String[] args) throws ConstructorException {

        int i = 0;
        throw new ConstructorException("i == 0，出错了");
    }
}
