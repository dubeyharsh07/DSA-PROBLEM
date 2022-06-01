package com.practice.collectionsinterface.sets;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {

    public static void main(String[] args) {

        Set<String> studentNames = new TreeSet<>();
        studentNames.add("Rohit");
        studentNames.add("Sachin");
        studentNames.add("Virat");
        studentNames.add("Rahul");
        // studentNames.add(null);  -- cannot add null elements to the set.

        System.out.println(studentNames); // here it maintains the sorting order of the added elements.

        /*Example with own type
        * will it work or do we need to do something extra?
        * Exception while adding : Construction of sorted collection with non-comparable elements
        *
        * To resolve this we need to implement Comparable interface.
        * */
        StudentDemo student1 = new StudentDemo(100, "Rohit", "Sharma", "T20");
        StudentDemo student2 = new StudentDemo(101, "Virat", "Kohli", "ODI");
        StudentDemo student3 = new StudentDemo(102, "Rahul", "Dravid", "TEST");
        StudentDemo student4 = new StudentDemo(103, "Sachin", "Tendulkar", "MASTER");

        Set<StudentDemo> classStudents = new TreeSet<>();
        classStudents.add(student1);
        classStudents.add(student2);
        classStudents.add(student3);
        classStudents.add(student4);
        // classStudents.add(null); --- cannot add null elements to the set.

        classStudents.forEach(System.out::println);

        classStudents.forEach(studentDemo -> {
            System.out.println(studentDemo.hashCode());
        });

        System.out.println(studentNames.remove("Ganguly"));

        System.out.println(classStudents.remove(student4));

        System.out.println("Is student exists: " +classStudents.contains(student4));

        classStudents.forEach(System.out::println);

    }
}
