package com.practice.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsLowerBoundDemo {

    public static void main(String[] args) {
        List<Number> integerList = new ArrayList<>();
        integerList.add(100);
        integerList.add(200);

        printList(integerList);

        List<Number> doubleList = new ArrayList<>();
        doubleList.add(111.11);
        doubleList.add(295.67);

        printList(doubleList);

        System.out.println(integerList);
        System.out.println(doubleList);

    }

    /**
     * Here, we have solved the problem of adding data to the passed list
     * by using the super class of Integer & Double
     * We cannot use Object class the compiler will not be able to guess what kind of data is present in the list.
     * @param list
     */
    private static void printList(List<? super Number> list) {
        list.forEach(System.out::println);
        list.add(195);
        list.add(137.45);
    }
}
