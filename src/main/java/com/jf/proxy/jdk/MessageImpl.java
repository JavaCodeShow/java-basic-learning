package com.jf.proxy.jdk;

/**
 * @author 江峰
 * @create 2020-11-04   17:12
 */
public class MessageImpl implements MessageInterface {
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
