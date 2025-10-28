package com.genericsTransport.vehicles;

import com.genericsTransport.passengers.Passenger;

public class Car<T extends Passenger> extends Vehicle<T>{

    public Car(String brand, int capacity, String licencePlate){
        super(brand, capacity, licencePlate);
    }

    @Override
    public String toString(){
        return "Car: " + brand + ", " + licencePlate + ", " + takenSpots + "/" + capacity + " passengers";
    }
}