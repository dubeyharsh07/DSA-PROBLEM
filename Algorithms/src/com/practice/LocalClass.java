package com.practice;

public class LocalClass {

    public static void main(String[] args) {
        int x = 10;

        System.out.println();
        class Foo {
            int i = x;
        }
        // x = 20; doesn't work x has to be final or effectively final.

    }
}
