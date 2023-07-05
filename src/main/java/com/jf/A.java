package com.jf;

import java.util.concurrent.*;

class FutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 创建一个线程池，用于执行Callable任务
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 创建一个 Callable 任务
        CallableTask task = new CallableTask();

        // 构造 Future 对象
        Future<String> future = executorService.submit(task);

        // 开启5个线程等待 future 的执行结果
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                try {
                    // 获取并输出计算结果
                    String result = future.get();
                    System.out.println("Thread " + Thread.currentThread().getId() + " Result: " + result);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }

        // 关闭线程池
        executorService.shutdown();
    }

    private static class CallableTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            // 模拟耗时操作
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
            return "Hello, Future!";
        }
    }
}
