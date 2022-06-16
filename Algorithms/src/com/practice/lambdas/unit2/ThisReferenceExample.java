package com.practice.lambdas.unit2;

public class ThisReferenceExample {

    public static void main(String[] args) {

        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();

        thisReferenceExample.doProcess(10, i -> {
            System.out.println("value is : "+ i);
           // System.out.println(this); -- This reference will not work with static reference, that's why lambda is different from anonymous class
        });

        thisReferenceExample.execute();
    }

    public void doProcess(int i, Process p) {
        p.process(i);
    }

    public void execute() {
        doProcess(10, i -> {
            System.out.println("value is : "+ i);
            System.out.println(this); // here with the instance method it's work.
        });
    }

    @Override
    public String toString() {
        return "ThisReferenceExample class instance.";
    }
}
