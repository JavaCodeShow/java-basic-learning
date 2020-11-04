package com.jf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        // Method add = list.getClass().getDeclaredMethod("add", Object.class);
        // Object abc = add.invoke(list, "abc");
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            iterator.remove();
        }
        // System.out.println(abc);
        System.out.println(list);

    }
}