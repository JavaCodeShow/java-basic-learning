package com.jf;

import com.jf.newfeature.User;

public class Main {

    public static void main(String[] args) {
        User user1 = new User();
        user1.setAge(1);
        User user2 = new User();
        System.out.println(user1);
        fun(user1, user2);
        System.out.println(user1.getAge());

    }

    private static void fun(User user1, User user2) {
        user1.setAge(2);
    }
}