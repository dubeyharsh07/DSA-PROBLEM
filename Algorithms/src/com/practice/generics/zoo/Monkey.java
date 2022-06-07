package com.practice.generics.zoo;

public class Monkey extends Animal implements Eats, Runs{

    @Override
    public void eat() {
        System.out.println("I'm eating my food.");
    }

    @Override
    public void run() {
        System.out.println("I'm running.!");
    }
}
