package com.jf;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis % 1000 == 0) {
                // 获取当前整秒时间
                long timestampInSeconds = currentTimeMillis / 1000;
                log.info("整点秒级时间");
            }

            TimeUnit.MILLISECONDS.sleep(1000);
        }
        hello

    }
}

1