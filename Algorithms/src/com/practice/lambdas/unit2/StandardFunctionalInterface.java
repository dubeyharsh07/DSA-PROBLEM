package com.practice.lambdas.unit2;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StandardFunctionalInterface {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Charles", "Dickens", 60));
        people.add(new Person("Lewis", "Carrol", 42));
        people.add(new Person("Thomas", "Carlyle", 51));
        people.add(new Person("Charlotte", "Bronte", 45));
        people.add(new Person("Matthew", "Arnold", 39));

        /*
        * By default, the java language provides the default functional interface which can be used to write lambda functions.
        * Predicate<T> : to test some condition.
        * Consumer<T> : to apply some operation.
        * */

        printListConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p.getFirstName()));

        /*Print all*/
        printListConditionally(people, p -> true, System.out::println);

    }

    private static void printListConditionally(List<Person> people, Predicate<Person> predicate,
                                               Consumer<Person> consumer) {
        people.forEach(person -> {
            if (predicate.test(person)) {
                consumer.accept(person);
            }
        });
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
