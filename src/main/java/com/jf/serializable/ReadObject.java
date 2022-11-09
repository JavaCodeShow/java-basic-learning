package com.jf.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectInputStream is = new ObjectInputStream(
                new FileInputStream("student.txt"));
        List<Student> list = (ArrayList<Student>) is.readObject();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }

    }
}
