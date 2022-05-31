package com.practice.collectionsinterface.comparable;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student(101, "Amit", "Science");
        Student student2 = new Student(100, "Ajay", "Commerce");
        Student student3 = new Student(102, "Akira", "Science");

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        System.out.println(students);

        students.sort(null);

        System.out.println("After sorting");
        System.out.println(students);

    }
}
