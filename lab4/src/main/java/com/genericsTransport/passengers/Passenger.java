package com.genericsTransport.passengers;

public class Passenger {

    protected String name;
    protected int age;

    public Passenger(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Passenger: " + name + ", " + age;
    }
}
