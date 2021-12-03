package com.practice;

import java.util.concurrent.atomic.AtomicInteger;

public class DateRaceExample {


    public static void main(String[] args) {
        AtomicInteger sharedVariable = new AtomicInteger(5);

        Thread thread1 = new Thread(() -> {
            sharedVariable.getAndSet(10);
        });

        Thread thread2 = new Thread(() -> {
            sharedVariable.getAndSet(20);
        });


        thread1.start();
        thread2.start();
        System.out.println("Value of shared variable: "+sharedVariable.get());
    }
}
