package com.genericsTransport.vehicles;

import java.util.ArrayList;

import com.genericsTransport.passengers.Passenger;

public class Bus<T extends Passenger> extends Vehicle<T>{

    private static final ArrayList<Vehicle<?>> allBuses = new ArrayList<>();
    
    private boolean onDuty = false;

    public Bus(String brand, int capacity, String licencePlate){
        super(brand, capacity, licencePlate);
        allBuses.add(this);
    }

    @Override
    public void addPassenger(T p) {
        if (!onDuty) {
            throw new RuntimeException("Cannot add passenger while off duty");
        }
        super.addPassenger(p);
    }

    @Override
    public void removePassenger(T p) {
        if (passengers.isEmpty()) {
            throw new RuntimeException("There is no passengers to remove");
        }
        super.removePassenger(p);
    }

    public void startDuty() {
        if (onDuty) {
            throw new RuntimeException("Bus (" + licencePlate + ") is already on duty");
        }
        onDuty = true;
        System.out.println("Bus (" + licencePlate + ") started routing");
    }

    public void endDuty() {
        if (!onDuty) {
            throw new RuntimeException("Bus (" + licencePlate + ") is already off duty");
        }
        else if(!passengers.isEmpty()){
            throw new RuntimeException("Cannot go off duty while still having passengers");
        }
        onDuty = false;
        System.out.println("Bus (" + licencePlate + ") has gone of duty");
    }

    public boolean ifOnDuty(){
        return onDuty;
    }

    @Override
    public String toString(){
        return  "Bus:" + 
                "\n\tBrand - " + brand + 
                "\n\tLicence plate - " + licencePlate +
                "\n\tTaken spots - " + takenSpots +
                "\n\tOn duty - " + onDuty;
    }
}