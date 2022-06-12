package com.practice.lambdas;

public class RunnableExample {

    public static void main(String[] args) {
        /*
        Traditional way of creating runnable task using Anonymous class
         */
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running a non lambda task.!");
            }
        });

        thread.start();

        /*
        Lambda way of creating runnable task.
         */
        Thread lambdaThread = new Thread(() -> {
            int a = 5, b = 10;
            System.out.println("Running a lambda task.!");
            System.out.println("Addition: "+ (a+b));
            System.out.println("Subtraction: "+ (a-b));
            System.out.println("Multiplication: "+ (a*b));
            System.out.println("Division: "+ (b/a));
        });
        lambdaThread.start();

    }
}
