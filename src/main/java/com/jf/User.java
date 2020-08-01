package com.jf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 江峰
 * @date 2020/7/13 14:49
 */
public class User {
    private Integer id;
    private String name;
    private int age;

    public User(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "java8_new_features.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        User user1 = new User(1, "张三", 11);
        User user2 = new User(2, "李四", 22);
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        // 过滤
        // List<java8_new_features.User> collect = list.stream().filter(user -> user.getId() == 1).collect(Collectors.toList());

        // 获取list用的某个字段
        // List<Integer> collect = list.stream().map(user -> user.getId()).collect(Collectors.toList());

        // 转换为map
        Map<Integer, User> collect = list.stream().collect(Collectors.toMap(User::getId, User -> User));

        System.out.println(collect);
    }
}
