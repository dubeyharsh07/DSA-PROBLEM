package com.practice;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RaceConditionExample {

    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        RaceConditionExample raceCondition = new RaceConditionExample();
        Lock lock = new ReentrantLock();

        System.out.println(map);

        Runnable task = () -> {
            raceCondition.execute(map, 100, "book1",lock);
        };

        Runnable task1 = () -> {
            raceCondition.execute(map, 101, "book1",lock);
        };
        new Thread(task).start();
        new Thread(task1).start();

        System.out.println(map);
    }

    private void execute(HashMap<String, Integer> map, Integer userId, String bookId, Lock lock) {

        lock.lock();
        if(!map.containsKey(bookId)) {
            System.out.println("Thread trying to update: "+ Thread.currentThread().getName());
            map.put(bookId,userId);
        }
        System.out.println(map);
        lock.unlock();
    }
}

