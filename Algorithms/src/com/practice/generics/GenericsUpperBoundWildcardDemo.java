package com.practice.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsUpperBoundWildcardDemo {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(100);
        integerList.add(200);

        printNumbers(integerList);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(100d);
        doubleList.add(200d);
        doubleList.add(300d);

        printNumbers(doubleList);
    }

    private static void printNumbers(List<? extends Number> list) {
        /**
         * how to make printNumbers method generic to print all types of "Number" list.
         * you need to add wildcard "? extends Number" to make it work.
         * basically you need to use the Super class.
         */
        list.forEach(System.out::println);
        Number number = list.get(0); // this will work not like previous example where you get the Object from the list.
        System.out.println(number);
    }
}
