package com.practice.collectionsinterface.comparator;


import java.util.ArrayList;
import java.util.Comparator;

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

        students.sort(new NameSortComparator());

        System.out.println("After sorting");
        System.out.println(students);

        // with anonymous class usage.
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId() - o2.getId();
            }
        });

        System.out.println("After sorting");
        System.out.println(students);

    }
}
