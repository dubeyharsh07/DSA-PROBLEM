package com.practice;

public class CopyConstructorPattern {
    public static void main(String[] args) {
        Car myCar = new Car();
        System.out.println("My car name is : "+myCar.getName());
        System.out.println("My car mileage : "+myCar.getMileage());

        Car myCar1 = new Car(12.6, "Venue", 5, 4);

        System.out.println(myCar1);

        Car neighbourCar = new Car(myCar1);

        System.out.println(neighbourCar);

    }
}

class Car {
    private int seats;
    private int wheels;
    private double mileage;
    private String name;

    private static final String COPY_TEXT = "Copied ";

    Car () {
        mileage = 0.0;
    }
    Car(double mileage, String name, int seats, int wheels) {
        this.mileage = mileage;
        this.name = name;
        this.wheels = wheels;
        this.seats = seats;
    }
    Car(Car otherCar) {
        this.mileage = otherCar.mileage;
        this.seats = otherCar.seats;
        this.wheels = otherCar.wheels;
        this.name = COPY_TEXT +otherCar.name;
    }

    public int getSeats() {
        return seats;
    }

    public int getWheels() {
        return wheels;
    }

    public double getMileage() {
        return mileage;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Details of Car{" +
                "seats=" + seats +
                ", wheels=" + wheels +
                ", mileage=" + mileage +
                ", name='" + name + '\'' +
                '}';
    }
}
