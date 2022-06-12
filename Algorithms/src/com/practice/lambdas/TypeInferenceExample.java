package com.practice.lambdas;

public class TypeInferenceExample {

    public static void main(String[] args) {

        StringLengthLambda stringLengthLambda = String::length;

        // Below Here, compiler is type inferring that variable 's' is of type String
        StringLengthLambda stringLengthLambda1 = s -> s.length();

        System.out.println("Length of string is : "+ stringLengthLambda.calculateLength("Hello World.!"));
        System.out.println("Length of string is : "+ stringLengthLambda1.calculateLength("Hello World.!"));

        printLambda(stringLengthLambda1);
    }

    public static void printLambda(StringLengthLambda stringLengthLambda) {
        System.out.println(stringLengthLambda.calculateLength("Hello World.!"));
    }
}

interface StringLengthLambda{
    int calculateLength(String str);
}
