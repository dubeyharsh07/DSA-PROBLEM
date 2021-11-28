package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * A demo class to demonstrate the usage of creating a new thread per request or using executor service to create a
 * fixed thread pool to process multiple requests.
 * Fixed thread pool: makes use of allocated thread pool size.
 * Cached thread pool: keeps on creating a new thread based on the need.
 * Single Thread executor: As the name suggest, manages with a single thread.
 * WorkStealingPool: It creates the fork join pool with worker threads to achieve parallelism.
 * */
public class ExecutorServiceDemo {

    private static ExecutorService service = Executors.newWorkStealingPool();
    // private static ExecutorService service = Executors.newFixedThreadPool(10);
    // private static ExecutorService service = Executors.newCachedThreadPool();
    // private static ExecutorService service = Executors.newSingleThreadExecutor();
    public static void main(String[] args) {
        List<Future<Integer>> futures = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            futures.add(service.submit(new Task()));
        }

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Task1());
            thread.start();
        }


        /*for (Future<Integer> future: futures) {
            try {
                System.out.println("future value:: "+future.get());
            } catch (InterruptedException | ExecutionException e) {
                System.err.println(e.fillInStackTrace());
            }
        }*/
    }
}

class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Integer val = new Random().nextInt(50);
        System.out.println("val : "+ val);
        System.out.println("Thread name: "+Thread.currentThread().getName());
        return val;
    }
}

class Task1 implements Runnable {

    @Override
    public void run() {
        Integer val = new Random().nextInt(50);
        System.out.println("val : "+ val);
        System.out.println("Thread name: "+Thread.currentThread().getName());
    }
}
