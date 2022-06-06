package com.practice.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsRuntimeCheck {

    public static void main(String[] args) {

        /* Generics is compiled time construct
        *  Here we are proving the type erasure concept of generic.
        *  once the code is compiled & byte code generated then the associated type is erased.
        *  and we are able to add integer value but once we read the data we got the class cast exception.
        *  So, always use Generics with the method as well -- look at the incorrect implementation.
        * */
        List<String> names = new ArrayList<>();
        addCorrectName(names, "Name1");
        addCorrectName(names, "Name2");

        System.out.println(names);

        addIncorrectValue(names, 100);

        System.out.println(names);

       // String name = names.get(2); // throws class cast exception.
    }

    private static void addIncorrectValue(List list, Integer value) {
        list.add(value); // if you don't use
    }

    private static void addCorrectName(List<String> list, String valueToAdd) {
        list.add(valueToAdd);
    }
}
