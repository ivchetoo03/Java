package com.genericsTransport.vehicles;

import java.util.ArrayList;
import java.util.List;

import com.genericsTransport.passengers.Passenger;

public class Taxi extends Car<Passenger>{

    private static final List<Taxi> allTaxis = new ArrayList<>();
    
    private boolean isAvailable = true;
    private int pricePerKm;
    private int distanceToTravel = 0;

    public Taxi(String brand, int capacity, String licencePlate, int pricePerKm){
        super(brand, capacity, licencePlate);
        this.pricePerKm = pricePerKm;
        allTaxis.add(this);
    }

    public void startTravel(int distanceToTravel){
        if (!isAvailable) {
            throw new RuntimeException("Taxi (" + licencePlate + ") is not available for new travel");
        }
        else if(passengers.isEmpty()){
            throw new RuntimeException("Taxi (" + licencePlate + ") has no passengers to pick up");
        }
        this.distanceToTravel = distanceToTravel;
        System.out.println("Taxi(" + licencePlate + ") has started travel for " + distanceToTravel +"km\n");
        isAvailable = false;
        System.out.println("Taxi (" + licencePlate + ") is now unavailable\n");
    }
    
    public void endTravel(){
        if (isAvailable) {
            throw new RuntimeException("Taxi (" + licencePlate + ") has no travel to end");
        }
        int travelCost = distanceToTravel * pricePerKm;
        System.out.println("Taxi (" + licencePlate + ") has ended travel.\nFinal cost of travel - " + travelCost + "\n");
        removeAllPassengers();
        distanceToTravel = 0;
        isAvailable = true;
        System.out.println("Taxi (" + licencePlate + ") is now available\n");
    }

    public boolean getIfAvailable() {
        return isAvailable;
    }

    @Override
    public String toString(){
        return  "Taxi:" + 
                "\n\tBrand - " + brand + 
                "\n\tLicence plate - " + licencePlate +
                "\n\tTaken spots - " + takenSpots +
                "\n\tIs available - " + isAvailable +
                "\n\tPrice per km - " + pricePerKm;
    }

}