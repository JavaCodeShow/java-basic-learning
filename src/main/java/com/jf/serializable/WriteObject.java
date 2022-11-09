package com.jf.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class WriteObject {
    public static void main(String[] args) throws IOException {
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三"));
        list.add(new Student("李四"));
        ObjectOutputStream os = new ObjectOutputStream(
                new FileOutputStream("student.txt"));
        os.writeObject(list);
        os.close();

    }
}
