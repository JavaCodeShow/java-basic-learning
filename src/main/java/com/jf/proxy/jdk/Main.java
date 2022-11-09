package com.jf.proxy.jdk;

public class Main {
    public static void main(String[] args) {
        MessageInterface message = (MessageInterface) JdkProxyFactory.getProxy(new MessageImpl());
        message.send("hello");
    }
}
