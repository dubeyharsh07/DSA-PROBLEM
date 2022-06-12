package com.practice.lambdas;

public class RichTextGreeting implements Greeting{

    @Override
    public void greet() {
        System.out.println("Hello World in rich text format !!");
    }
}
