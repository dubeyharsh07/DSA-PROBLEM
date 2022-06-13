package com.practice.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Unit1_ExerciseJava8 {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Charles", "Dickens", 60));
        people.add(new Person("Lewis", "Carrol", 42));
        people.add(new Person("Thomas", "Carlyle", 51));
        people.add(new Person("Charlotte", "Bronte", 45));
        people.add(new Person("Matthew", "Arnold", 39));

        printList(people);
        // Step1 : Sort list by the last names.
        // Step2 : Print all the elements in the list.
        // Step3 : Print all the People whose last name starts with letter 'C'

        System.out.println("####### Sorting the list #########");
        people.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));


        System.out.println("####### Sorted list #########");
        printList(people);

        // another way to sort the list.
        System.out.println("####### Another way of sorting the list #########");
        people.sort(Comparator.comparing(Person::getAge));
        printList(people);

        System.out.println("####### Print name in the list who's last name starts with C  #########");
        printListConditionally(people, p -> p.getLastName().startsWith("C"));

        // if you want to print all.
        System.out.println("###### Print all irrespective of the condition ############");
        printListConditionally(people, p -> true);

    }

    private static void printList(List<Person> people) {
        people.forEach(System.out::println);
    }

    private static void printListConditionally(List<Person> people, Condition condition) {
        people.forEach(person -> {
            if (condition.test(person)) {
                System.out.println(person);
            }
        });
    }
}

