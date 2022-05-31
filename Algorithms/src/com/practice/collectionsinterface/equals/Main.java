package com.practice.collectionsinterface.equals;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(101, "Amit", "Science");
        Student student2 = new Student(102, "Prakash", "Biology");
        Student student3 = new Student(101, "Amit", "Science");

        System.out.println(Objects.equals(student1,student3));

        System.out.println(student1 == student3);

        System.out.println(student1.equals(student2));

        System.out.println("##########-----HASH CODES------####");

        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        System.out.println(student3.hashCode());

        // If we don't implement the hashcode and equals method in the Student class then the result will be different.
        // for obj == obj1 and obj.equals(obj1)


    }
}
