package com.kpi.zaranik.producerconsumer;

public class Main {

    public static void main(String[] args) {
        SharedQueue<Integer> sharedQueue = new SharedQueue<>(1000000);

        ProducerThread producerThread = new ProducerThread(sharedQueue);
        ConsumerThread consumerThread = new ConsumerThread(sharedQueue);

        producerThread.start();
        consumerThread.start();
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}