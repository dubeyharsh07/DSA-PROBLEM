package com.practice.lambdas;

public class Greeter {

    public static void main(String[] args) {

        Greeter greeter = new Greeter();
        /*
          Interface based implementation
         */
        Greeting richTextGreeting = new RichTextGreeting();
        greeter.greetPeople(richTextGreeting);

        /*
          Lambda function based implementation.
          As we know that class instance is not required for lambda, it infers by the compiler.
          If the lambda function matches the contract then it will work.
          If we add any new method in the Greeting interface then below-mentioned line will throw compile time err
         */
        Greeting lambdaGreeting = () -> System.out.println("Hello World the lambda way !!");
        greeter.greetPeople(lambdaGreeting);

        /*
          Anonymous class example.
         */
        Greeting anonymousClassGreeting = new Greeting() {
            @Override
            public void greet() {
                System.out.println("Hello World using the anonymous class !!");
            }
        };
        greeter.greetPeople(anonymousClassGreeting);



    }

    public void greetPeople(Greeting greeting) {
        greeting.greet();
    }
}
