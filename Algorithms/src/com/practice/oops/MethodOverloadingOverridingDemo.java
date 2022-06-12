package com.practice.oops;

public class MethodOverloadingOverridingDemo {

    public static void main(String[] args) {
        System.out.println("Method Override");
        Drivable sportsCar = new SportsCar();
        driveCar(sportsCar);

        Drivable suvCar = new SuvCar();
        driveCar(suvCar);

        System.out.println("======********==========");
        System.out.println("Method Overload");
        SportsCar sportsCar1 = new SportsCar();
        driveCar(sportsCar1);

        SuvCar suvCar1 = new SuvCar();
        driveCar(suvCar1);

    }

    private static void driveCar(Drivable car) {
        car.drive();
    }

    private static void driveCar(SportsCar car) {
        car.drive();
    }

    private static void driveCar(SuvCar car) {
        car.drive();
    }
}

interface Drivable {
    void drive();
}

class SportsCar implements Drivable {

    @Override
    public void drive() {
        System.out.println("Sports car is driving.!");
    }
}

class SuvCar implements Drivable {

    @Override
    public void drive() {
        System.out.println("SUV car is driving.!");
    }
}
