package com.practice.collectionsinterface.comparable;

public class Student implements Comparable<Student>{

    private Integer id;
    private String name;
    private String department;

    public Student(Integer id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }


    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
