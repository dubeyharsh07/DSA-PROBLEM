package com.practice.collectionsinterface.sets;

public class StudentDemo implements Comparable<StudentDemo> {

    private Integer id;
    private String firstName;
    private String lastName;
    private String stream;

    public StudentDemo(Integer id, String firstName, String lastName, String stream) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stream = stream;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStream() {
        return stream;
    }

    @Override
    public String toString() {
        return "StudentDemo{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", stream='" + stream + '\'' +
                '}';
    }

    @Override
    public int compareTo(StudentDemo student) {
        return this.firstName.compareTo(student.firstName);
    }
}
