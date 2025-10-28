package com.genericsTransport.vehicles;

import java.util.ArrayList;

import com.genericsTransport.passengers.Policeman;

public class PoliceCar extends Car<Policeman>{

    private static final ArrayList<PoliceCar> allPoliceCars = new ArrayList<>();
    
    private boolean onDuty = false;
    private boolean isChasing = false;

    public PoliceCar(String brand, int capacity, String licencePlate){
        super(brand, capacity, licencePlate);
        allPoliceCars.add(this);
    }

    @Override
    public void addPassenger(Policeman p) {
        if (isChasing) {
            throw new RuntimeException("Cannot add passenger during chase!");
        }
        super.addPassenger(p);
    }

    @Override
    public void removePassenger(Policeman p) {
        if (isChasing) {
            throw new RuntimeException("Cannot remove passenger during chase!");
        }
        super.removePassenger(p);
    }

    public void startDuty() {
        if (onDuty) {
            throw new RuntimeException("Police car (" + licencePlate + ") is already on duty");
        }
        onDuty = true;
        System.out.println("Police car (" + licencePlate + ") is on duty");
    }

    public void endDuty() {
        if (!onDuty) {
            throw new RuntimeException("Police car (" + licencePlate + ") is already off duty");
        }
        onDuty = false;
        System.out.println("Police car (" + licencePlate + ") has finished duty");
    }
    
    public void startChase() {
        if (!onDuty) {
            throw new RuntimeException("Can't start a chase if off duty");
        } 
        else if(isChasing){
            throw new RuntimeException("Can't start a chase if already chasing someone");
        }
        System.out.println("CHASE! Police car (" + licencePlate + ") has started pursuing someone!");
        isChasing = true;
    }
    
    public void stopChase() {
        if(!isChasing){
            throw new RuntimeException("Police car (" + licencePlate + ") is not chasing anyone");
        }
        isChasing = false;
        System.out.println("Police car (" + licencePlate + ") has ended the chase!");
    }

    public boolean ifOnDuty(){
        return onDuty;
    }

    public boolean ifChasing(){
        return isChasing;
    }

    @Override
    public String toString(){
        return  "Police car:" + 
                "\n\tBrand - " + brand + 
                "\n\tLicence plate - " + licencePlate +
                "\n\tTaken spots - " + takenSpots +
                "\n\tOn duty - " + onDuty +
                "\n\tIs chasing someone - " + isChasing;
    }
}
