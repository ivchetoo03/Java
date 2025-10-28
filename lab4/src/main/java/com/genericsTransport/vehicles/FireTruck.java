package com.genericsTransport.vehicles;

import java.util.ArrayList;

import com.genericsTransport.passengers.Fireman;

public class FireTruck extends Car<Fireman>{

    private static final ArrayList<FireTruck> allFireTrucks = new ArrayList<>();
    
    private boolean onDuty = false;
    private boolean activeFire = false;

    public FireTruck(String brand, int capacity, String licencePlate){
        super(brand, capacity, licencePlate);
        allFireTrucks.add(this);
    }

    @Override
    public void addPassenger(Fireman p) {
        if (onDuty && activeFire) {
            throw new RuntimeException("Cannot add passenger while heading to active fire!");
        }
        super.addPassenger(p);
    }

    @Override
    public void removePassenger(Fireman p) {
        if (onDuty && activeFire) {
            throw new RuntimeException("Cannot remove passenger while heading to active fire!");
        }
        super.removePassenger(p);
    }

    public void startDuty() {
        if (onDuty) {
            throw new RuntimeException("Fire truck (" + licencePlate + ") is already on duty");
        }
        else if (!activeFire) {
            throw new RuntimeException("Fire truck (" + licencePlate + ") has no fire to extinguish");
        }
        onDuty = true;
        System.out.println("Fire truck (" + licencePlate + ") is heading to active fire!");
    }

    public void endDuty() {
        if (!onDuty) {
            throw new RuntimeException("Fire truck (" + licencePlate + ") is already off duty");
        }
        else if(activeFire){
            throw new RuntimeException("Fire truck (" + licencePlate + ") cannot end duty while assigned active fire ");
        }
        onDuty = false;
        System.out.println("Fire truck (" + licencePlate + ") has returned to the fire station");
    }
    
    public void informAboutActiveFire() {
        if(activeFire){
            throw new RuntimeException("Can't assign active fire while already having one");
        }
        System.out.println("FIRE! Fire truck (" + licencePlate + ") was assigned active fire!");
        activeFire = true;
    }
    
    public void extinguishFire() {
        if(!activeFire){
            throw new RuntimeException("Fire truck (" + licencePlate + ") does not have active fire to extinguish");
        }
        activeFire = false;
        System.out.println("Fire truck (" + licencePlate + ") has extinguished the fire!");
    }

    public boolean ifOnDuty(){
        return onDuty;
    }

    public boolean ifActiveFire(){
        return activeFire;
    }

    @Override
    public String toString(){
        return  "Police car:" + 
                "\n\tBrand - " + brand + 
                "\n\tLicence plate - " + licencePlate +
                "\n\tTaken spots - " + takenSpots +
                "\n\tOn duty - " + onDuty +
                "\n\tAssigned active fire  - " + activeFire;
    }
}
