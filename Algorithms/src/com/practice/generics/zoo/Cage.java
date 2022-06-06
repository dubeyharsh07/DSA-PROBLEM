package com.practice.generics.zoo;

public class Cage<E extends Animal> {

    private E animal1;
    private E animal2;

    public E getAnimal1() {
        return animal1;
    }

    public void setAnimal1(E animal1) {
        this.animal1 = animal1;
    }

    public E getAnimal2() {
        return animal2;
    }

    public void setAnimal2(E animal2) {
        this.animal2 = animal2;
    }

    public boolean isCompatible() {
        /**
         * Here, we are able to access the Animal variables because we have the upper bound as Animal.
         * And we are using parameterized type.
         */
        return this.animal1.getType().equals(this.animal2.getType());
    }
}
