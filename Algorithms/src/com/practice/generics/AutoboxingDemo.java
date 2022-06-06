package com.practice.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AutoboxingDemo {

    public static void main(String[] args) {

        int x = 10;
        Integer i = x;

        /* Just like above autoboxing works with Generic list */
        List<Integer> numbers = Arrays.asList(10,20,30,40,50);

        Iterator<Integer> integerIterator = numbers.iterator();
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }



        numbers.forEach(System.out::println);
    }
}
