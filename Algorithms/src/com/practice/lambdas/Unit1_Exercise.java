package com.practice.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Unit1_Exercise {

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
        people.sort(new LastNameComparator()); // can use inline comparator as well.

        System.out.println("####### Sorted list #########");
        printList(people);

        System.out.println("####### Filtering the list #########");
        filterListWithLastName(people, "C");

        System.out.println("####### Printing the list conditionally #########");
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return p.getLastName().startsWith("C");
            }
        });

        System.out.println("####### Program ends #########");


    }

    private static void printList(List<Person> people) {
        for(Person person : people)
            System.out.println(person);
    }

    private static void filterListWithLastName(List<Person> people, String searchStr) {
        for(Person person : people) {
            if(person.getLastName().startsWith(searchStr))
                System.out.println(person);
        }
    }

    private static void printConditionally(List<Person> people, Condition condition) {
        for (Person person : people) {
            if (condition.test(person))
                System.out.println(person);
        }
    }
}

class LastNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getLastName().compareTo(p2.getLastName());
    }
}

interface Condition {
    boolean test(Person p);
}

class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }
}