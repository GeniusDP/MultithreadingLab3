package com.kpi.zaranik.producerconsumer;

import java.time.LocalTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConsumerThread extends Thread {

    private final SharedQueue<Integer> sharedBuffer;

    @Override
    public void run() {
        while (true) {
            int value = sharedBuffer.take();
            SimpleLogger.printLine("[" + LocalTime.now() + "]" + " [CONSUMER] Got message: " + value);
        }
    }
}