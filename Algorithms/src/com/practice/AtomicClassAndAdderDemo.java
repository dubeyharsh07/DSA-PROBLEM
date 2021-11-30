package com.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * In this example you can compare the performance of AtomicLong/AtomicInteger and LongAdder by a start/end time.
 */
public class AtomicClassAndAdderDemo {

    private static AtomicLong counter = new AtomicLong(0);
    private static LongAdder adder = new LongAdder();
    private static ExecutorService service = Executors.newFixedThreadPool(16);

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            service.submit(new AtomicTask(counter));
        }
        long end = System.currentTimeMillis() - start;

        System.out.println("The time required to finish Atomic task: "+ end);
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            service.submit(new AdderTask(adder));
        }
        end = System.currentTimeMillis() - start;

        System.out.println("The time required to finish Adder task: "+ end);

        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("The value of counter is : "+counter.get());
        System.out.println("The value of adder is : "+adder.sum());

    }
}

class AtomicTask implements Runnable {

    private AtomicLong counter;

    public AtomicTask(AtomicLong counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        //System.out.println("Atomic task called.");
        counter.incrementAndGet();
    }
}

class AdderTask implements Runnable {

    private LongAdder adder;

    public AdderTask(LongAdder adder) {
        this.adder = adder;
    }

    @Override
    public void run() {
        adder.increment();
    }
}

