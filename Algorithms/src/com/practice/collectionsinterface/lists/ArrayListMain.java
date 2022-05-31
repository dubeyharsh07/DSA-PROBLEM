package com.practice.collectionsinterface.lists;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>(5);
        names.add("Name A");
        names.add("Name B");

        System.out.println(names);

        names.add(1, "Name C");

        System.out.println(names);

        System.out.println(names.contains("Name A"));

        System.out.println("Size of the list: " +names.size());

        System.out.println("Element at index 0: "+ names.get(0));

        // System.out.println(names.get(100)); Exception in thread java.lang.IndexOutOfBoundsException: Index: 100, Size: 3

        System.out.println("Removing element at index 0: "+ names.remove(0));

        names.set(1, "Name D");

        System.out.println(names);

    }
}
