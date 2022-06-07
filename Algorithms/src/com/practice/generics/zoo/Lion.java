package com.practice.generics.zoo;

public class Lion extends Animal implements Eats, Runs{

    @Override
    public void eat() {
        System.out.println("I'm eating my animal food.");
    }

    @Override
    public void run() {
        System.out.println("I'm running to hunt !!");
    }

}
