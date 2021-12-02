package com.practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockBasics {

    private Lock lockA = new ReentrantLock();
    private Lock lockB = new ReentrantLock();

    public static void main(String[] args) {

        DeadlockBasics deadlockBasics = new DeadlockBasics();
        deadlockBasics.execute();

    }

    private void execute() {
        new Thread(this::processThis).start();
        new Thread(this::processThat).start();

    }

    /**
     * to print the JVM stacktrace to find the deadlock.
     * use below command.
     * ps -eaf | grep "java" --> it will list java process id.
     * kill -3 {processId}
     */
    private void processThis() {
        lockA.lock();
        // some tasks
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lockB.lock();

        lockA.unlock();
        lockB.unlock();
    }

    private void processThat() {
        lockB.lock();
        // some tasks

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lockA.lock();

        lockA.unlock();
        lockB.unlock();
    }

}


