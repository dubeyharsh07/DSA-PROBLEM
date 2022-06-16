package com.practice.lambdas.unit2;

public class ClosureExample {

    public static void main(String[] args) {

        int a = 5;
        int b = 10;

        /*
         * if you modify/update the value of 'b' then compiler throws an exception that 'b'
         * should be effectively final.
         * The java compiler keeps an eye on the first value assigned.
         */
        //b = 15;
        doProcess(a, i -> System.out.println(b+a));
    }

    public static void doProcess(int i, Process p) {
        p.process(i);
    }
}

interface Process {
    void process(int i);
}
