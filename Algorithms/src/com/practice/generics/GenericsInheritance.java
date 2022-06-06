package com.practice.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsInheritance {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Name 1");
        names.add("Name 2");

        printList(names);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(200);
        numbers.add(300);

        printList(numbers);

    }

    private static void printList(List<?> list) {
        /**
         * how to make printList method generic to print any type of the list.
         * you need to add wildcard "?" to make it work.
         */
        list.forEach(System.out::println);
        // list.add(100); -- this will not work because compiler will not know what data exists in the list.
    }
}
