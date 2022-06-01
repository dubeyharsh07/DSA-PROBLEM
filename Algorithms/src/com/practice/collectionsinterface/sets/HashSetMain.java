package com.practice.collectionsinterface.sets;

import java.util.HashSet;
import java.util.Set;

public class HashSetMain {

    public static void main(String[] args) {

        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(4);
        numbers.add(3);
        numbers.add(2);

        System.out.println(numbers);

        boolean isSetChanged = numbers.add(3); // adding same number again & checking if it's added to set or not
        System.out.println(isSetChanged);

        System.out.println("is number exists: " + numbers.contains(2));

        System.out.println("Size of the set: " + numbers.size());

        boolean isNumberRemoved = numbers.remove(4);
        System.out.println(isNumberRemoved);
        System.out.println(numbers);

        numbers.forEach(System.out::println);

    }
}
