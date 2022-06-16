package com.practice.lambdas.unit3;

import com.practice.lambdas.Greeting;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionChanges {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Charles", "Dickens", 60));
        people.add(new Person("Lewis", "Carrol", 42));
        people.add(new Person("Thomas", "Carlyle", 51));
        people.add(new Person("Charlotte", "Bronte", 45));
        people.add(new Person("Matthew", "Arnold", 39));

        // Advancement to the for loop

        System.out.println("Using for loop");

        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }

        System.out.println("Using for in (for enhanced) loop");

        for (Person p : people) {
            System.out.println(p);
        }

        System.out.println("Using lambda for each loop");
        people.forEach(System.out::println);

        Stream<Person> stream = people.stream();

        System.out.println("Print names from the people list");
        stream.forEach(System.out::println);

        System.out.println("Filter results from stream.");
        people.stream().filter( person -> person.getLastName().startsWith("C"))
                .forEach(System.out::println);

        System.out.println("Count of people matching the condition");

        long count = people.stream().filter(person -> person.getFirstName().startsWith("C"))
                .count();
        System.out.println("Count is : "+count);

        Optional<Person> first = people.stream().filter(person -> person.getFirstName().startsWith("C"))
                .findFirst();
        System.out.println(first.orElse(null));

        System.out.println("Collect list of person based on the condition");
        List<Person> personList = people.stream().filter(person -> person.getFirstName().startsWith("C"))
                .collect(Collectors.toList());
        System.out.println(personList);

        List<Person> parallelStreamList = people.parallelStream().collect(Collectors.toList());

        System.out.println(parallelStreamList);


    }


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
