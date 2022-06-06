package com.practice.generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericsDemo {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Name 1");
        names.add("Name 2");
        // names.add(new Date()); // The moment we made it generic it errors out at compile time
        names.add("Name 3");

        String newlyAddedName = (String) names.get(2); /* java.lang.ClassCastException: java.util.Date
        cannot be cast to java.lang.String*/

        System.out.println(newlyAddedName);



    }

    private static void addIncorrectValue(List list, Object value) {
        list.add(value);
    }

    private static void addCorrectName(List list, String valueToAdd) {
        list.add(valueToAdd);
    }
}
