package com.practice;

public class AbstractClassDemo {

    public static void main(String[] args) {
        Animal dog = new Dog(4); // Animal class is abstract, cannot instantiate.
        dog.move();
        System.out.println("Legs of the animal: " +dog.getLegs());
        // dog.speak(); this method is not available in Animal class.

        System.out.println("=====*****======");

        PetAnimal dog1 = new Dog(4);
        dog1.speak();
        dog1.move();
        System.out.println("Legs of the animal: " +dog1.getLegs());

        System.out.println("=====*****======");
        PetAnimal cat = new Cat(4);
        cat.speak();
        cat.move();
        System.out.println("Legs of the animal: " +cat.getLegs());

        System.out.println("=====*****======");
        Dog dogWithoutParams = new Dog();
        dogWithoutParams.move();
        System.out.println("Legs of the animal: " +dogWithoutParams.getLegs());

    }
}

abstract class Animal {
    private int legs;
    Animal() {

    }
    Animal(int legs) {
        System.out.println("Animal constructor called.");
        this.legs = legs;
    }

    public int getLegs() {
        return legs;
    }

    abstract void move();
}

abstract class PetAnimal extends Animal {

    PetAnimal() {

    }

    PetAnimal(int legs) {
        super(legs);
        System.out.println("Pet Animal constructor called.");
    }

    abstract void speak();
}

class Dog extends PetAnimal {

    Dog() {

    }
    Dog(int legs) {
        super(legs);
        System.out.println("Actual Dog called.");
    }
    @Override
    void move() {
        System.out.println("Dog is running.");
    }

    @Override
    void speak() {
        System.out.println("Dog is barking.");
    }
}

class Cat extends PetAnimal {

    Cat(int legs) {
        super(legs);
        System.out.println("Actual Cat called.");
    }
    @Override
    void move() {
        System.out.println("Cat is walking.");
    }

    @Override
    void speak() {
        System.out.println("Cat is meowing.");
    }
}