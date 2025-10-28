package com.genericsTransport.vehicles;

import com.genericsTransport.passengers.Passenger;
import java.util.ArrayList;

public abstract class Vehicle<T extends Passenger> {

    private static final ArrayList<Vehicle<?>> allVehicles = new ArrayList<>();
    
    protected String brand;
    protected String licencePlate;
    protected int capacity; 
    protected int takenSpots = 0; 
    protected ArrayList<T> passengers;

    public Vehicle(String brand, int capacity, String licencePlate){
        this.brand = brand;
        this.licencePlate = licencePlate;
        this.capacity = capacity;
        passengers = new ArrayList<>(capacity);
        allVehicles.add(this);
    }

    public void addPassenger(T passenger){
        if(takenSpots == capacity){
            throw new RuntimeException("This " + getClass().getSimpleName() + " is already full");
        }
        passengers.add(passenger);
        takenSpots+=1;
        System.out.println("Passenger " + passenger + " was added to " + getClass().getSimpleName());
    }
    
    public void addPassengerList(ArrayList<? extends T> passengersToAdd){
        if(takenSpots + passengersToAdd.size() > capacity){
            throw new RuntimeException("There's no space for all the passengers in the group");
        }
        for(T passenger : passengersToAdd){
            passengers.add(passenger);
        }
        takenSpots+=passengersToAdd.size();
        System.out.println("List of passengers was added to " + getClass().getSimpleName());
    }
    
    public void transferFrom(Vehicle<? extends T> vehicle) {  // Changed 'Car' to 'Vehicle'
        try{
            if(takenSpots + vehicle.passengers.size() > capacity){
                throw new RuntimeException("There's no space for all the passengers in the " + getClass().getSimpleName());
            }
            else if(vehicle.passengers.size() == 0){
                throw new RuntimeException("The " + getClass().getSimpleName() + " has no passengers to transfer");
            }
            
            passengers.addAll(vehicle.passengers);
            takenSpots+=vehicle.passengers.size();
            vehicle.passengers.clear();
            vehicle.takenSpots = 0;
            System.out.println("Transfer completed");
        }
        catch(ClassCastException e){
            System.out.println(vehicle.getClass().getSimpleName() + " passengers are not compatible with " + getClass().getSimpleName());
        }
    }
    
    public void removePassenger(T passenger){
        if(!passengers.contains(passenger)){
            throw new RuntimeException("The " + getClass().getSimpleName() + " does not have that passenger");
        }
        passengers.remove(passenger);
        takenSpots-=1;
        System.out.println("Passenger " + passenger + " was removed from " + getClass().getSimpleName());
    }
    
    public void removeAllPassengers(){
        passengers.clear();
        takenSpots = 0;
        System.out.println("All passengers were removed from " + getClass().getSimpleName());
    }

    public int getCapacity(){
        return capacity;
    }

    public int getTakenSpots(){
        return takenSpots;
    }

    public abstract String toString();
}