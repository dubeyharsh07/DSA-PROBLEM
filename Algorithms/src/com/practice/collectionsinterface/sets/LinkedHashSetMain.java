package com.practice.collectionsinterface.sets;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetMain {

    public static void main(String[] args) {
        Set<String> names = new LinkedHashSet<>();
        names.add("Name A");
        names.add("Name D");
        names.add("Name C");
        names.add("Name B");

        System.out.println(names); // here insertion order is maintained.

        // Collections.EMPTY_SET;  -- Utility method to return empty set.


    }
}
