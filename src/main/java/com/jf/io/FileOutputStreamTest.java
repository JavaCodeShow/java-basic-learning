package com.jf.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream output = new FileOutputStream("output.txt");
        byte[] array = "hello".getBytes();
        output.write(array);
    }
}
