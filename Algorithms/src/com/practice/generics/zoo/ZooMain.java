package com.practice.generics.zoo;

public class ZooMain {

    public static void main(String[] args) {
        Cage<Monkey> monkeyCage = new Cage<>();
        Cage<Lion> lionCage = new Cage<>();

        monkeyCage.setAnimal1(new Monkey());
        monkeyCage.setAnimal2(new Monkey());

        lionCage.setAnimal1(new Lion());
        lionCage.setAnimal2(new Lion());

        /**
            But this is very possible that monkey cage can have the Lion
            If we don't review our code properly because there is no compile time check.
            For rescue, we can create our own Generic type.

            monkeyCage.setAnimal2(new Lion());
            // It will fail in production but not during building the code.
            Monkey monkey = (Monkey) monkeyCage.getAnimal2();

         */
        Monkey monkey = (Monkey) monkeyCage.getAnimal2();
        /**
         * The moment we add parameterized type 'E' then compiler won't let us perform this operation.
         * monkeyCage.setAnimal2(new Lion());
         */

        /**
         * To fix the below problem we have to use the upper bound wildcard so that the cage can
         * only be created for Animal type.
          */
        // Cage<String> stringCage = new Cage<>(); // This is the problem.


    }
}
