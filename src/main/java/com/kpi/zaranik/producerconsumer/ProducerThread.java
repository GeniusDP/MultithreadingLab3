package com.kpi.zaranik.producerconsumer;

import java.time.LocalTime;
import java.util.Date;
import java.util.Random;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProducerThread extends Thread {

    private final SharedQueue<Integer> sharedBuffer;

    @Override
    public void run() {
        Random random = new Random(new Date().getTime());
        while (true) {
            int value = Math.abs(random.nextInt()) % 1000;
            sharedBuffer.put(value);
            SimpleLogger.printLine("[" + LocalTime.now() + "]" + " [PRODUCER] Sent message: " + value + ". Shared buffer maximum size: " + sharedBuffer.getMaximumSize());
        }
    }

}