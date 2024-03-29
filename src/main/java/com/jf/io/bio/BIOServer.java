package com.jf.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-7-7 23:48
 */
public class BIOServer {

    public static void main(String[] args) throws IOException {

        /**
         * 1.创建一个线程池
         * 如果有客户端连接了，就创建一个线程与之通信。
         */
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        // 创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(6668);

        System.out.println("服务器启动了");

        while (true) {
            // 监听，等待客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("连接到了一个客户端");
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    // 可以和客户端通讯
                    handler(socket);
                }
            });
        }

    }

    // 编写一个handler方法，与客户端通讯
    public static void handler(Socket socket) {
        // 通过socket获取输入流
        try {
            System.out.println("线程信息 id=" + Thread.currentThread().getId() + "线程名字=" + Thread.currentThread().getName());
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];

            // 循环的读取客户端发送的数据
            while (true) {
                System.out.println("线程信息 id=" + Thread.currentThread().getId() + "线程名字=" + Thread.currentThread().getName());

                int read = inputStream.read(bytes);
                if (read != -1) {
                    // 输出客户端发送的数据
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭和客户端的连接
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
