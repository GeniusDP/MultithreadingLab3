package com.kpi.zaranik.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.SneakyThrows;

public class SharedQueue<T> {

    private final ArrayBlockingQueue<T> queue;
    private int maximumSize = 0;

    private final Lock lock = new ReentrantLock();

    public SharedQueue(int capacity) {
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    @SneakyThrows
    public T take() {
        return queue.take();
    }

    @SneakyThrows
    public void put(T object) {
        queue.put(object);
        lock.lock();
        try {
            int size = queue.size();
            if (size > maximumSize) {
                maximumSize = size;
            }
        } finally {
            lock.unlock();
        }
    }

    public int getMaximumSize() {
        return this.maximumSize;
    }
}
