package com.practice.lambdas.unit3;

public class MethodReferenceExample {

    public static void main(String[] args) {
        Thread thread = new Thread(MethodReferenceExample::printMessage); // example of method reference

        //Thread thread = new Thread(() -> printMessage()); //-- traditional way of lambda executing method

        thread.start();
    }

    public static void printMessage() {
        System.out.println("Hello.!");
    }

}
