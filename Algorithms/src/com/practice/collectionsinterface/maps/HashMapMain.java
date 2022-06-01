package com.practice.collectionsinterface.maps;

import com.practice.collectionsinterface.sets.StudentDemo;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {

    public static void main(String[] args) {
        Map<Integer, StudentDemo> studentMap= new HashMap<>();

        StudentDemo student1 = new StudentDemo(100, "Rohit", "Sharma", "T20");
        StudentDemo student2 = new StudentDemo(101, "Virat", "Kohli", "ODI");
        StudentDemo student3 = new StudentDemo(102, "Rahul", "Dravid", "TEST");
        StudentDemo student4 = new StudentDemo(103, "Sachin", "Tendulkar", "MASTER");


        studentMap.put(student1.getId(), student1);
        studentMap.put(student2.getId(), student2);
        studentMap.put(student3.getId(), student3);
        studentMap.put(student4.getId(), student4);
        studentMap.put(student3.getId(), student3); // trying to add duplicate
        studentMap.putIfAbsent(student4.getId(), student4); // safe way to put the element in the collection.

        System.out.println(studentMap);

        for (Integer keys : studentMap.keySet()) {
            System.out.println(keys);
        }

        for (StudentDemo student : studentMap.values()) {
            System.out.println(student);
        }

        studentMap.remove(101);
        studentMap.remove(200);

        for (Map.Entry<Integer, StudentDemo> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println("contains key: "+studentMap.containsKey(103));

        studentMap.computeIfAbsent(103,
                key -> new StudentDemo(key, "Saurav", "Ganguly", "CAPTAIN"));

        for (Map.Entry<Integer, StudentDemo> entry : studentMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
