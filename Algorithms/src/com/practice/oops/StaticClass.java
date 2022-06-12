package com.practice.oops;

public class StaticClass {

    public static void main(String[] args) {
       // StaticCar myCar = new StaticCar(); you need to provide default constructor if you have given parameterized one.
        StaticCar myCar = new StaticCar(12.5, "Hyundai Venue", 5, 4);
        System.out.println(myCar);

        StaticCar neighbourCar = new StaticCar(7, "MG Hector", 7, 4);
        System.out.println(neighbourCar);
        System.out.println(myCar); // caused the data corruption because of static member.
    }
}

class StaticCar {
    private static int seats;
    private int wheels;
    private double mileage;
    private String name;

    StaticCar(double mileage, String name, int seats, int wheels) {
        this.mileage = mileage;
        this.name = name;
        this.wheels = wheels;
        StaticCar.seats = seats;
       // this.seats = seats;  won't work Static member accessed via instance reference
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