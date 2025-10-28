package com.genericsTransport.road;

import java.util.ArrayList;
import com.genericsTransport.vehicles.Vehicle;

public class Road {
    
    private ArrayList<Vehicle<?>> vehiclesOnRoad = new ArrayList<>();
    
    public int getCountOfPassengers(){
        int passengerCount = 0;
        for(Vehicle<?> vehicle : vehiclesOnRoad){
            passengerCount += vehicle.getTakenSpots();
        }
        return passengerCount;
    }

    public void addVehicle(Vehicle<?> vehicle){
        if(vehiclesOnRoad.contains(vehicle)){
            throw new RuntimeException("Road already contains that vehicle");
        }
        vehiclesOnRoad.add(vehicle);
    }

    public void removeVehicle(Vehicle<?> vehicle){
        if(!vehiclesOnRoad.contains(vehicle)){
            throw new RuntimeException("Road does not contain that vehicle");
        }
        vehiclesOnRoad.remove(vehicle);
    }

    public ArrayList<Vehicle<?>> getVehicles(){
        return vehiclesOnRoad;
    }
}
