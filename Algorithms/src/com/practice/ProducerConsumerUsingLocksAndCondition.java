package com.practice;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This example shows how to use locks and condition to create the producer-consumer solution.
 * Producer thread will add the data to the Queue & signals consumer thread to consume the data.
 * Consumer thread will read the data from the queue & signals producer thread that it has read the data.
 */
public class ProducerConsumerUsingLocksAndCondition {

    public static void main(String[] args) {
        ProducerConsumerImpl producerConsumer = new ProducerConsumerImpl();
       /* Producer producer = new Producer(producerConsumer);
        Consumer consumer = new Consumer(producerConsumer);

        consumer.start();
        producer.start();*/

        for(int i=1; i<=10;i++) {
            if(i%2 == 1) {
                Consumer consumer = new Consumer(producerConsumer);
                consumer.start();
            }else {
                Producer producer = new Producer(producerConsumer);
                producer.start();
            }
        }
    }
}

class ProducerConsumerImpl {

    private static final Integer CAPACITY = 10;
    private final Queue<Integer> queue = new LinkedList<>();
    private final Random random = new Random();

    // Locks and conditions
    private final Lock lock = new ReentrantLock();
    private final Condition added = lock.newCondition();
    private final Condition removed = lock.newCondition();

    public void put() throws InterruptedException {
        lock.lock();
        try{
            if(queue.size() == CAPACITY) {
                System.out.println(Thread.currentThread().getName() + " : Buffer is full, waiting");
                removed.await(); //waiting for buffer to get empty.
            }
            Integer value = random.nextInt(100);
            boolean isAdded = queue.offer(value);
            if(isAdded) {
                System.out.println("Added object to the queue by thread " +Thread.currentThread().getName() + " value:"+value);
                // signal consumer thread that, buffer has element now
                System.out.println(Thread.currentThread().getName() + " : Signalling that buffer is no more empty now");
                added.signalAll();
            }

        }finally {
            lock.unlock();
        }
    }

    public void get() throws InterruptedException{
        lock.lock();
        try{
            if(queue.size() == 0){
                System.out.println(Thread.currentThread().getName() + " : Buffer is empty, waiting");
                added.await();
            }
            Integer data = queue.poll();
            if(Objects.nonNull(data)) {
                System.out.println("Fetched object from the queue by thread " +Thread.currentThread().getName() + " value:"
                        + data);
                // signal producer thread that, buffer may be empty now
                System.out.println(Thread.currentThread().getName() + " : Signalling that buffer may be empty now");
                removed.signalAll();
            }
        }finally {
            lock.unlock();
        }
    }


}

class Producer extends Thread {

    private final ProducerConsumerImpl producerConsumer;

    public Producer(ProducerConsumerImpl producerConsumer){
        super("Producer");
        this.producerConsumer = producerConsumer;
    }

    @Override
    public void run() {
        try {
            producerConsumer.put();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {

    private final ProducerConsumerImpl producerConsumer;

    public Consumer(ProducerConsumerImpl producerConsumer){
        super("Consumer");
        this.producerConsumer = producerConsumer;
    }

    @Override
    public void run() {
        try {
            producerConsumer.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
