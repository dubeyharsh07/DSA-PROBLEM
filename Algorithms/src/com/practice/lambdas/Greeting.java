package com.practice.lambdas;

@FunctionalInterface
public interface Greeting {
    void greet();

    default void anotherGreet() {
        System.out.println("Default method.");
    }
    // void anotherGreet1(); -- Not allowed with Functional interface annotation.
}
