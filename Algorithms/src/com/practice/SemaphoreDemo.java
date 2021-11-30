package com.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreDemo {

    private static Semaphore semaphore = new Semaphore(5);
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            executorService.submit(new SemaphoreTask(semaphore, i));
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}

class SemaphoreTask implements Runnable {

    private Semaphore semaphore;
    private Integer value;

    public SemaphoreTask(Semaphore semaphore, Integer value) {
        this.semaphore = semaphore;
        this.value = value;
    }

    @Override
    public void run() {
        semaphore.acquireUninterruptibly();
        System.out.println("Value is: "+ this.value);
        System.out.println("Available permits: "+semaphore.availablePermits());
        semaphore.release();
    }
}
