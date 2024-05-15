package com.jf;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.TimeUnit;

public class DeadlockDetector {
    public static void main(String[] args) {
        final Object a = new Object();
        final Object b = new Object();
        Thread threadA = new Thread(() -> {
            synchronized (a) {
                try {
                    System.out.println("now i in threadA-locka");
                    TimeUnit.SECONDS.sleep(1);
                    synchronized (b) {
                        System.out.println("now i in threadA-lockb");
                    }
                } catch (Exception e) {
                    // ignore
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (b) {
                try {
                    System.out.println("now i in threadB-lockb");
                    TimeUnit.SECONDS.sleep(1);
                    synchronized (a) {
                        System.out.println("now i in threadB-locka");
                    }
                } catch (Exception e) {
                    // ignore
                }
            }
        });

        threadA.start();
        threadB.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.findDeadlockedThreads();

        if (threadIds != null) {
            ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds);
            System.out.println("Detected Deadlock Threads:");
            for (ThreadInfo threadInfo : threadInfos) {
                System.out.println(threadInfo.getThreadName());
            }
        } else {
            System.out.println("No Deadlock Detected.");
        }
    }
}
